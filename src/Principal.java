import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import javax.swing.JFrame;

public class Principal {
    
    public static void main (String args []) throws ClassNotFoundException, SQLException, IOException{
            LogInUI log = null;
            log = new LogInUI ();
            log.setVisible (true);
            log.setLocationRelativeTo (null);
            log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            log.pack ();
            
        }
	
}
