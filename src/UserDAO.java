import java.sql.*;
import java.util.ArrayList;

public class UserDAO {
	
	private Connection connection;
	private Statement statement;
        private User user;
	

	public UserDAO () throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/1?autoReconnect=true&useSSL=false", "root", "7654JprG");
		
	}
	
	//cria a tabela para os users
	public void init () {
		try {									
			String sql = "SET GLOBAL max_allowed_packet=?";
			PreparedStatement p_statement = this.connection.prepareStatement(sql);
			p_statement.setInt(1, 80540528);
			p_statement.executeUpdate();
			
			this.statement = this.connection.createStatement();
				sql = "CREATE TABLE USERS" + 
					 " (email VARCHAR (255), " +
					 " password VARCHAR (255)) ";
				
			this.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
        
        
	
	public boolean logIn (String user_email, String user_password) throws SQLException {
		boolean sucess = false;
		String sql = "SELECT * FROM USERS WHERE email=?";
		PreparedStatement p_statement = this.connection.prepareStatement(sql);
		p_statement.setString(1, user_email);
		ResultSet rs = p_statement.executeQuery();
		
		while (rs.next()) {
			String check = rs.getString("password");
			if (check.equals(user_password)) {
				sucess = true;
			}
			
		}		
		p_statement.close();
		return sucess;
		
	}
	
		
		 
		 
		 
	//atualiza os dados de um user
	public void updateUser (User user, String change, int coluna) throws SQLException {
		
		String sql = null;
		
		if (coluna == 1) {
			sql = "update USERS set email=? where email=?";
		}
		
		else {
			sql = "update USERS set password=? where email=?";
		}
		
		PreparedStatement p_statement = this.connection.prepareStatement(sql);
		p_statement.setString(1, change);
		p_statement.setString(2, user.get_email());
		p_statement.executeUpdate();
		
		
		p_statement.close();
		
	}
	
	//adiciona um user à tabela
	public void addUser (User e) throws SQLException {
		String sql = null;
		sql = "INSERT INTO USERS (email, password)"
				+ "Values (?,?)";
		
		PreparedStatement p_statement = this.connection.prepareStatement(sql);
		p_statement.setString(1,e.get_email());
		p_statement.setString(2,e.get_password());
		p_statement.executeUpdate();
		
		p_statement.close();
	}
	
	//remove um user da tabela
	public void removeUser (User e) throws SQLException {
		String sql = null;
		sql = "DELETE FROM USERS where email = ?";
		
		PreparedStatement p_statement = this.connection.prepareStatement(sql);
		p_statement.setString(1, e.get_email());
		p_statement.executeUpdate();
		
		p_statement.close();
	}
	
	
}
