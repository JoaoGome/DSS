
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class UserMusicDAO {
	
	private Connection connection;
	private Statement statement;
	
	public UserMusicDAO () throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/1?autoReconnect=true&useSSL=false", "root", "7654JprG");
	}
	
	//cria a tabela que associa os users às suas musicas
	public void init () {
		try {
			this.statement = this.connection.createStatement();
			String sql = "CREATE TABLE MUSICA_USER" + 
					 "(user_email VARCHAR (255), " +
					 " musica_id INTEGER not NULL)";
			
			
			this.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
		
	//adiciona uma ligação à tabela
	public void add_ligacao (String user_email, int musica_id) throws SQLException {
		String sql = null;
		sql = "INSERT INTO MUSICA_USER (user_email, musica_id)"
				+ "Values (?, ?)";
			
		PreparedStatement p_statement = this.connection.prepareStatement(sql);
		
		p_statement.setString(1,user_email);
		p_statement.setInt(2,musica_id);
		p_statement.executeUpdate();
			
		p_statement.close();
	}
	
	//remove uma ligação da tabela
	public void remove_ligacao (String user_email, int musica_id) throws SQLException {
		String sql = null;
		sql = "DELETE FROM MUSICA_USER where user_email = ?, musica_id=? ";
			
		PreparedStatement p_statement = this.connection.prepareStatement(sql);
		p_statement.setString(1, user_email);
		p_statement.setInt(2, musica_id);
		p_statement.executeUpdate();
			
		p_statement.close();
	}

	//funçao que dado um user devolve o id de todas musicas a ele associado
	
	public ArrayList <Integer> devolveMusica (String user_email) throws SQLException {
		ArrayList <Integer> lista_ids = new ArrayList <Integer> ();
		String sql = null;
		
		sql = "SELECT musica_id FROM MUSICA_USER where user_email = ?";
		PreparedStatement p_statement = this.connection.prepareStatement(sql);
		p_statement.setString(1, user_email);
		ResultSet rs = p_statement.executeQuery();
		
		while (rs.next()) {
			lista_ids.add(rs.getInt("musica_id"));
		}
		
		p_statement.close();
		return lista_ids;
		
	}
	
}