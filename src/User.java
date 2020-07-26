
import java.sql.SQLException;

public class User {
    
	private String email;
	private String password;
	private boolean admin;
	
	
	
	public User (String email, String password, boolean admin) throws SQLException, ClassNotFoundException {
		this.email = email;
		this.password = password;
		this.admin = admin;
	}

	public String get_email () {
		return this.email;
	}
	
	public String get_password () {
		return this.password;
	}
	

	public void set_email (String email) {
		this.email = email;
	}
	
	public void set_password (String password) {
		this.password = password;
	}
	
	public void to_string () {
		StringBuilder sb = new StringBuilder ();
		sb.append("Email: " + this.get_email() + "\n");
		sb.append("Password: " + this.get_password() + "\n");
		
		System.out.println(sb);
	}
	
}	
	
