import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Library {
    private static final String libraryName = "FC Internazionale\n";


    public static void addBook(Book book) throws SQLException {
        Connection connection = DatabaseConnector.connect();
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO `books`(`id`, `book_name`, `book_author`, `book_ganre`, `book_isbn`) VALUES (null,'%s','%s','%s','%s')".formatted(book.getBookName(), book.getBookAuthor(), book.getBookGenre(), book.getBookISBN()));
        System.out.println("Book Successfully added");
    }

    public static void showAllBooks() throws SQLException{
        Connection connection = DatabaseConnector.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `books`");
        while(resultSet.next()){
            System.out.println("id: %d) %s, %s, %s - (isbn: %s)".formatted(Integer.parseInt(resultSet.getString("id")),resultSet.getString("book_name"), resultSet.getString("book_author"), resultSet.getString("book_ganre"), resultSet.getString("book_isbn")));
        }
    }

    public static String getLibraryName() {
        return libraryName;
    }
    public String toString(){
        return libraryName;
    }
}
