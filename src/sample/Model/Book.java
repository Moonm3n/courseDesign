package sample.Model;

public class Book {
    private String bookName;
    private String bookID;
    private String author;
    private String publisher;
    private int bookNum;
    private String location;

    public Book(String bookName, String bookID, String author, String publisher, int bookNum, String location) {
        this.bookName = bookName;
        this.bookID = bookID;
        this.author = author;
        this.publisher = publisher;
        this.bookNum = bookNum;
        this.location = location;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
