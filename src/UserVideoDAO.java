import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class UserVideoDAO {
	
	private Connection connection;
	private Statement statement;
	
	
	public UserVideoDAO () throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/1?autoReconnect=true&useSSL=false", "root", "7654JprG");
	}
	
	//cria a tabela que associa os users aos seus videos
	public void init () {
		try {
			this.statement = this.connection.createStatement();
			String sql = "CREATE TABLE VIDEO_USER" + 
					 "(user_email VARCHAR (255), " +
					 " video_id INTEGER not NULL) ";
			
			this.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
		
	//adiciona uma ligaçao à playlist
	public void add_ligacao (String user_email, int video_id) throws SQLException {
		String sql = null;
		sql = "INSERT INTO VIDEO_USER (user_email, video_id)"
				+ "Values (?, ?)";
			
		PreparedStatement p_statement = this.connection.prepareStatement(sql);
		
		p_statement.setString(1,user_email);
		p_statement.setInt(2,video_id);
		p_statement.executeUpdate();
			
		p_statement.close();
	}
	
	//remove uma ligação da tabela
	public void remove_ligacao (String user_email, int video_id) throws SQLException {
		String sql = null;
		sql = "DELETE FROM VIDEO_USER where user_email = ?, video_id=? ";
			
		PreparedStatement p_statement = this.connection.prepareStatement(sql);
		p_statement.setString(1, user_email);
		p_statement.setInt(2, video_id);
		p_statement.executeUpdate();
			
		p_statement.close();
	}
	
	//devolve os ids de todos os videos associados a um user
	public ArrayList <Integer> devolveVideo (String user_email) throws SQLException {
		ArrayList <Integer> lista_ids = new ArrayList <Integer> ();
		String sql = null;
		
		sql = "SELECT video_id FROM VIDEO_USER where user_email = ?";
		PreparedStatement p_statement = this.connection.prepareStatement(sql);
		p_statement.setString(1, user_email);
		ResultSet rs = p_statement.executeQuery();
		
		while (rs.next()) {
			lista_ids.add(rs.getInt("video_id"));
		}
		
		p_statement.close();
		return lista_ids;
		
	}
	
}