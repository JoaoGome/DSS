import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class CategoriaMusicDAO {
	
	private Connection connection;
	private Statement statement;
	
	public CategoriaMusicDAO () throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/1?autoReconnect=true&useSSL=false", "root", "7654JprG");
	}
	
	//cria a tabela que associa o user e as categorias das suas musicas sem interferir com as musicas dos outros
	public void init () {
		try {
			this.statement = this.connection.createStatement();
			String sql = "CREATE TABLE CATEGORIAS_MUSICAS" + 
					 "(user_email VARCHAR (255), " +
					 " categoria_id VARCHAR (255), " + 
					 " musica_id INTEGER not NULL)";
			
			
			this.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
		
	//adiciona uma ligação à tabela
	public void add_ligacao (String user_email, int musica_id, String categoria_id) throws SQLException {
		String sql = null;
		sql = "INSERT INTO CATEGORIAS_MUSICAS (user_email, categoria_id, musica_id)"
				+ "Values (?, ?, ?)";
			
		PreparedStatement p_statement = this.connection.prepareStatement(sql);
		
		p_statement.setString(1,user_email);
		p_statement.setString(2,categoria_id);
		p_statement.setInt(3,musica_id);
		p_statement.executeUpdate();
			
		p_statement.close();
	}
	
	//remove uma ligação da tabela
	public void remove_ligacao (String user_email, int musica_id) throws SQLException {
		String sql = null;
		sql = "DELETE FROM CATEGORIAS_MUSICAS where user_email =?, musica_id=? ";
			
		PreparedStatement p_statement = this.connection.prepareStatement(sql);
		p_statement.setString(1, user_email);
		p_statement.setInt(2, musica_id);
		p_statement.executeUpdate();
			
		p_statement.close();
	}
	
	
	//funcao que altera uma categoria de uma musica para um dado user
	public void altera_categoria (String user_email, int musica_id, String categoria_id) throws SQLException {
		String sql = null;
		sql = " update CATEGORIAS_MUSICAS set categoria_id=? where user_email =  ? AND musica_id = ?";
		
		PreparedStatement p_statement = this.connection.prepareStatement(sql);
		p_statement.setString(1, categoria_id);
		p_statement.setString(2, user_email);
		p_statement.setInt(3, musica_id);
		p_statement.executeUpdate();
		
		p_statement.close();
	}
        
        //funcao que dado um user e uma musica, devolve a categoria
        
        public String devolve_categoria (String user_email, int musica_id) throws SQLException{
                String sql = null;
                sql = "SELECT * FROM CATEGORIAS_MUSICAS where user_email = ?";
                String answer = null;
                PreparedStatement p_statement = this.connection.prepareStatement(sql);
                p_statement.setString (1, user_email);
                ResultSet rs = p_statement.executeQuery();
                while (rs.next()) {
                    if (rs.getInt("musica_id") == musica_id)
                        answer = rs.getString("categoria_id");
                }
                
                
                return answer;
        }

	
}