import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DataBaseConnection {

 

 

public static Connection dbConn() {

String url = "jdbc:mysql://localhost:3306/studentdata";

String username ="root";

String password ="Pavithra@2708";

try {

Connection conn = DriverManager.getConnection(url,username,password);

return conn;


} catch (SQLException e) {

JOptionPane.showMessageDialog(null, "Connection Failed");

e.printStackTrace();

return null;

}

 

}

}