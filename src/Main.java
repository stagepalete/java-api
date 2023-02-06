import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connect = DatabaseConnector.connect();
        System.out.println(DatabaseConnector.isConnected());
        Statement statement = connect.createStatement();
        ResultSet resultset = statement.executeQuery("select * from booksetc");
        while (resultset.next()){
            System.out.println(resultset.getString("name"));
        }
    }

    public static void loginInterface(){
        System.out.println();
    }
}