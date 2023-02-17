import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Main {
    static User currentUser = null;
    public static void main(String[] args) throws SQLException {
        if(currentUser != null){
            mainInterface();
        }else{
            loginInterface();
        }

    }

    public static void loginInterface() throws SQLException {
        showAuthMenu();
        Scanner userOption = new Scanner(System.in);
        System.out.print("Select option: ");
        switch (userOption.nextInt()) {
            case 1 -> {
                while (currentUser == null) {
                    System.out.print("Enter username: ");
                    String username = userOption.next();
                    if (Objects.equals(username, "exit")){
                        loginInterface();
                    }
                    System.out.print("Enter password: ");
                    String password = userOption.next();
                    currentUser = User.logIn(username, password);
                    System.out.println(User.isLogged() ? User.getNAME() : "");
                }
                mainInterface();
            }
            case 2 -> {
                System.out.print("Enter your name: ");
                System.out.println("To go back, enter \"exit\"");
                String name = userOption.next();
                if (Objects.equals(name, "exit")){
                    loginInterface();
                }
                System.out.print("Enter your lastname: ");
                String lastname = userOption.next();
                System.out.print("Enter your username: ");
                String username = userOption.next();
                System.out.print("Enter password: ");
                String password1 = userOption.next();
                System.out.print("Enter your password one more time: ");
                String password2 = userOption.next();
                System.out.print("Enter your date of birth (YYYY-MM-DD): ");
                String DOB = userOption.next();
                currentUser = User.register(name, lastname, username, password1, password2, DOB);
                mainInterface();
            }

        }
    }
    public static void mainInterface() throws SQLException {
        Scanner userOption = new Scanner(System.in);
        int userInput = 0;
        while(userInput != 5){
            showMainMenu();
            System.out.print("Choose option: ");
            userInput = userOption.nextInt();
            switch (userInput){
                case 1 -> {
                    Library.showAllBooks();
                }
                case 2 -> {
                    currentUser.showMyBooks();
                }
                case 3 -> {
                    currentUser.pickUpBook();
                }
                case 4 -> {
                    currentUser.returnBook();
                }
            }
        }

    }

    public static void showAuthMenu(){
        ArrayList<String> authMenu = new ArrayList<String>();
        authMenu.add("Login"); authMenu.add("Register");
        int c = 1;
        for (String menuElem : authMenu){
            System.out.printf("%d) %s\n", c++, menuElem);
        }
    }

    public static void showMainMenu(){
        ArrayList<String> mainMenu = new ArrayList<String>();
        mainMenu.add("Show all books");
        mainMenu.add("Show my books");
        mainMenu.add("Pick up a book");
        mainMenu.add("Return the book");
        mainMenu.add("Log out");
        int c = 1;
        for(String menuElem : mainMenu){
            System.out.printf("%d) %s%n", c++, menuElem);
        }
    }
}