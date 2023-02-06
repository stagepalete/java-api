public class Book {
    private String bookName;
    private String bookAuthor;
    private String bookGenre;
    private String bookISBN;

    Book(){}
    public Book(String bookName, String bookAuthor, String bookGenre, String bookISBN){
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
        this.bookISBN = bookISBN;
    }







//    setters


    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    //Getters
    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public String getBookISBN() {
        return bookISBN;
    }

}
