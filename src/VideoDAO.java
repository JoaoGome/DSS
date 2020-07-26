
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

import com.sun.media.MediaPlayer;

import uk.co.caprica.vlcj.player.component.CallbackMediaPlayerComponent;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

public class VideoDAO {
	
	private Connection connection;
	private Statement statement;
	
	public VideoDAO () throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/1?autoReconnect=true&useSSL=false", "root", "7654JprG");
	}
	
	//cria a tabela dos videos 
	public void init () {
		try {
			this.statement = this.connection.createStatement();
			String sql = "CREATE TABLE VIDEO" + 
					 "(id INTEGER not NULL, " +
					 " name VARCHAR (255), " +
					 " categoria VARCHAR (255), " +
					 " file longblob ) ";
			
			this.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//adiciona um video à tabela
		public void upload (Video v, String file_path) throws SQLException, FileNotFoundException {
			String sql = null;
			sql = "INSERT INTO VIDEO (id, name, categoria, file)"
					+ "Values (?, ?, ?, ?)";
				
			PreparedStatement p_statement = this.connection.prepareStatement(sql);
			InputStream inputStream = new FileInputStream(new File(file_path));
			
			p_statement.setInt(1,v.get_id());
			p_statement.setString(2,v.get_name());
			p_statement.setString(3,v.get_categoria());
			p_statement.setBlob(4, inputStream);
			p_statement.executeUpdate();
				
			p_statement.close();
		}

	//remove um video da tabela
	public void removeVideo (Video v) throws SQLException {
		String sql = null;
		sql = "DELETE FROM VIDEO where id =?";
			
		PreparedStatement p_statement = this.connection.prepareStatement(sql);
		p_statement.setInt(1, v.get_id());
		p_statement.executeUpdate();
			
		p_statement.close();
	}
	
        public ArrayList <Video> devolveVideos (ArrayList <Integer> lista_ids) throws SQLException {
		ArrayList <Video> result = new ArrayList <Video> ();
		String sql = null;
		PreparedStatement p_statement;
		
		for (int i: lista_ids) {
			sql = "SELECT * from VIDEO where id=?";
			p_statement = this.connection.prepareStatement(sql);
			p_statement.setInt(1, i);
			ResultSet rs = p_statement.executeQuery();
			
			while (rs.next()) {
				Video novo = new Video (i, rs.getString("name"), rs.getString("categoria"));
				result.add(novo);
			}
		}
		
		return result;
		
	}
        
        public boolean verificaExiste (String name) throws SQLException {
            boolean answer = false;
            String sql = null;
            PreparedStatement p_statement;
            sql = "SELECT * from VIDEO";
            p_statement = this.connection.prepareStatement (sql);
            ResultSet rs = p_statement.executeQuery();
            
            while (rs.next()) {
                if (rs.getString("name").equals (name))
                    answer = true;
            }
            
            return answer;
            
        }
        
        public int devolve_id () throws SQLException {
            int count = 0;
            
            String sql = null;
            PreparedStatement p_statement;
            sql = "SELECT * from VIDEO";
            p_statement = this.connection.prepareStatement (sql);
            ResultSet rs = p_statement.executeQuery();
            
            while (rs.next()) {
                if (rs.getInt("id") > count) 
                    count = rs.getInt("id");
            }
            
            return (count + 1);
            
        }
        
	public void playVideo(int video_id) throws IOException, SQLException {
		
		InputStream is;
		String sql = null;
		PreparedStatement p_statement;
		
		sql = "SELECT file FROM VIDEO where id=?";
		p_statement = this.connection.prepareStatement(sql);
		p_statement.setInt(1, video_id);
		ResultSet rs = p_statement.executeQuery();
		rs.next();
		is = rs.getBinaryStream("file");
		
		
		File file = new File ("video");
		Files.copy(is, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
		CallbackMediaPlayerComponent component = new CallbackMediaPlayerComponent();

		JFrame f = new JFrame ();

		f.setContentPane(component);

		f.setBounds(new Rectangle (200,200,800,600));

		f.addWindowListener(new WindowAdapter() {

		    public void windowClosing (WindowEvent e) {

		    component.release();

		    System.exit(0);

		    }

		});

		f.setVisible(true);

		component.mediaPlayer().media().play("video");
                
               
    }
	
}
