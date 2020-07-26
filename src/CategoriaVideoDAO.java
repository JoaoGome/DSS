import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class CategoriaVideoDAO {
	
	private Connection connection;
	private Statement statement;
	
	public CategoriaVideoDAO () throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/1?autoReconnect=true&useSSL=false", "root", "7654JprG");
	}
	
	//cria a tabela que associa o user e as categorias dos seus videos sem interferir com os videos dos outros users
	public void init () {
		try {
			this.statement = this.connection.createStatement();
			String sql = "CREATE TABLE CATEGORIAS_VIDEOS" + 
					 "(user_email VARCHAR (255), " +
					 " categoria_id VARCHAR (255), " + 
					 " video_id INTEGER not NULL)";
			
			
			this.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
		
	//adiciona uma ligação à tabela
	public void add_ligacao (String user_email, int video_id, String categoria_id) throws SQLException {
		String sql = null;
		sql = "INSERT INTO CATEGORIAS_VIDEOS (user_email, categoria_id, video_id)"
				+ "Values (?, ?, ?)";
			
		PreparedStatement p_statement = this.connection.prepareStatement(sql);
		
		p_statement.setString(1,user_email);
		p_statement.setString(2,categoria_id);
		p_statement.setInt(3,video_id);
		p_statement.executeUpdate();
			
		p_statement.close();
	}
        
	//remove uma ligação da tabela
	public void remove_ligacao (String user_email, int video_id) throws SQLException {
		String sql = null;
		sql = "DELETE FROM CATEGORIAS_VIDEOS where user_email =?, video_id=? ";
			
		PreparedStatement p_statement = this.connection.prepareStatement(sql);
		p_statement.setString(1, user_email);
		p_statement.setInt(2, video_id);
		p_statement.executeUpdate();
			
		p_statement.close();
	}
        
        public String devolve_categoria (String user_email, int video_id) throws SQLException{
                String sql = null;
                sql = "SELECT * FROM CATEGORIAS_VIDEOS where user_email = ?";
                String answer = null;
                PreparedStatement p_statement = this.connection.prepareStatement(sql);
                p_statement.setString (1, user_email);
                ResultSet rs = p_statement.executeQuery();
                while (rs.next()) {
                    if (rs.getInt("video_id") == video_id)
                        answer = rs.getString("categoria_id");
                }
                
                
                return answer;
        }
	
	
	//funcao que altera uma categoria de uma musica para um dado user
	public void altera_categoria (String user_email, int video_id, String categoria_id) throws SQLException {
		String sql = null;
		sql = "update CATEGORIAS_VIDEOS set categoria_id=? where user_email=? AND video_id=?";
		
		PreparedStatement p_statement = this.connection.prepareStatement(sql);
		p_statement.setString(1, categoria_id);
		p_statement.setString(2, user_email);
		p_statement.setInt(3, video_id);
		p_statement.executeUpdate();
		
		p_statement.close();
	}

	
}