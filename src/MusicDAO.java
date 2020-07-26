
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.mysql.jdbc.Clob;

public class MusicDAO {
	
	private Connection connection;
	private Statement statement;
        
	
	public MusicDAO () throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/1?autoReconnect=true&useSSL=false", "root", "7654JprG");
	}
	
	//cria a tabela das musicas 
	public void init () {
		try {
			this.statement = this.connection.createStatement();
			String sql = "CREATE TABLE MUSIC" + 
					 "(id INTEGER not NULL, " +
					 " name VARCHAR (255), " +
					 " singer VARCHAR (255), " +
					 " categoria VARCHAR (255), " +
					 " album VARCHAR (255), " +
					 " ordem_album INTEGER not NULL, " +
					 " file longblob) ";
			
			this.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//adiciona uma música à tabela
		public void Upload (Music m, String file_path) throws SQLException, FileNotFoundException {
			String sql = null;
			sql = "INSERT INTO MUSIC (id, name, singer, categoria, album, ordem_album, file)"
					+ "Values (?, ?, ?, ?, ?, ?, ?)";
				
			PreparedStatement p_statement = this.connection.prepareStatement(sql);
			InputStream inputStream = new FileInputStream(new File(file_path));
			
			p_statement.setInt(1,m.get_musicID());
			p_statement.setString(2,m.get_name());
			p_statement.setString(3,m.get_singer());
			p_statement.setString(4,m.get_categoria());
			p_statement.setString(5,m.get_album());
			p_statement.setInt(6,m.get_ordemAlbum());
			p_statement.setBlob(7, inputStream);
			p_statement.executeUpdate();
				
			p_statement.close();
		}

	//remove uma musica da tabela
	public void removeMusic (Music m) throws SQLException {
		String sql = null;
		sql = "DELETE FROM MUSIC where id = ?";
			
		PreparedStatement p_statement = this.connection.prepareStatement(sql);
		p_statement.setInt(1, m.get_musicID());
		p_statement.executeUpdate();
			
		p_statement.close();
	}
	
	//funcao que recebe uma lista de ids de musica e da print para o ecran as musicas e as suas informaçoes
	public ArrayList <Music> devolveMusicas (ArrayList <Integer> lista_ids) throws SQLException {
		ArrayList <Music> result = new ArrayList <Music> ();
		String sql = null;
		PreparedStatement p_statement;
		
		for (int i: lista_ids) {
			sql = "SELECT * from MUSIC where id=?";
			p_statement = this.connection.prepareStatement(sql);
			p_statement.setInt(1, i);
			ResultSet rs = p_statement.executeQuery();
			
			while (rs.next()) {
				Music nova = new Music (i, rs.getString("name"), rs.getString("singer"), rs.getString("categoria"), rs.getString("album"), rs.getInt("ordem_album"));
				result.add(nova);
			}
		}
		
		return result;
		
	}
        
        public boolean verificaExiste (String name) throws SQLException {
            boolean answer = false;
            String sql = null;
            PreparedStatement p_statement;
            sql = "SELECT * from MUSIC";
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
            sql = "SELECT * from MUSIC";
            p_statement = this.connection.prepareStatement (sql);
            ResultSet rs = p_statement.executeQuery();
            
            while (rs.next()) {
                if (rs.getInt("id") > count) 
                    count = rs.getInt("id");
            }
            
            return (count + 1);
            
        }
	
	public void playMusic (int music_id) throws SQLException {
		
		InputStream is;
		String sql = null;
		PreparedStatement p_statement;
		
		sql = "SELECT file FROM MUSIC where id=?";
		p_statement = this.connection.prepareStatement(sql);
		p_statement.setInt(1, music_id);
		ResultSet rs = p_statement.executeQuery();
		rs.next();
		is = rs.getBinaryStream("file");
		
		try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(is);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
	    clip.start();
            Thread.sleep(clip.getMicrosecondLength()/1000);
            
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
        }
	}
		

	
}
