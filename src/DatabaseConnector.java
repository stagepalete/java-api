
import java.sql.*;

public class DatabaseConnector{
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/libraryassignment";
    private static final String  USERNAME = "root";
    private static final String PASSWORD = "";
    private static boolean isConnected = false;
    public static Connection connect(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            isConnected = true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    public static boolean isConnected(){
        return isConnected;
    }

}