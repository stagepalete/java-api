import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

public class User {
    //TODO:
    //1) login, register methods
    //2) Check for isLoggedIn
    //3)    \

    private static String NAME;
    private static String LASTNAME;
    private static String USERNAME;
    private static String DOB;
    private static boolean isLogged = false;

    public User(String name, String lastname, String username, String DOB){
        NAME = name;
        LASTNAME = lastname;
        USERNAME = username;
        User.DOB = DOB;
        isLogged = true;
    }

    public static User logIn(String username, String password) throws SQLException {
        User user = null;
        Connection connection = DatabaseConnector.connect();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("SELECT * FROM `users`");
        while(resultset.next()){
            if(Objects.equals(resultset.getString("username"), username) && Objects.equals(resultset.getString("password"), password)){
                String name = resultset.getString("name");
                String lastname = resultset.getString("lastname");
                String DateOfBirth = resultset.getString("DateOfBirth");
                user = new User(name, lastname, username, DateOfBirth);
            }
        }
        if(user == null){
            System.out.println("Invalid username or password!");
            return null;
        }
        return user;
    }
    public static User register(String name, String lastname, String username, String password, String password2, String DOB) throws SQLException {
        User user = null;
        Connection connection = DatabaseConnector.connect();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("select * from `users`");
        while(resultset.next()){
            if(Objects.equals(resultset.getString("username"), username)){
                System.out.println("Username is already taken");
                return null;
            }
        }
        if(!Objects.equals(password, password2)){
            return null;
        }
        statement.executeUpdate("INSERT INTO `users`(`id`, `name`, `lastname`, `username`, `password`, `DateOfBirth`) VALUES (null,'%s','%s','%s','%s','%s')".formatted(name, lastname, username, password, DOB));
        user = logIn(username, password);
        System.out.println("Account created successfully!");
        return user;
    }

    public static void showMyBooks() throws SQLException {
        Connection connection = DatabaseConnector.connect();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("SELECT  book_res.id, books.book_name, book_res.date_of_receipt, book_res.date_of_delivary FROM `book_res` INNER JOIN books ON book_res.book_id = books.id WHERE `user_id` = 3");

        while(resultset.next()){
            System.out.println("%d) %s, %s - %s".formatted(Integer.parseInt(resultset.getString("id")), resultset.getString("book_name"), resultset.getString("date_of_receipt"), resultset.getString("date_of_delivary")));
        }
    }

    public String toString(){
        return USERNAME;
    }

    public static String getNAME() {
        return NAME;
    }

    public static String getLASTNAME() {
        return LASTNAME;
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getDOB() {
        return DOB;
    }

    public static boolean isLogged(){
        return isLogged;
    }
}
