package sample.Model;

import java.sql.Timestamp;

public class Reader {

    private String readerName;
    private String readerId;
    private String password;
    private Timestamp idRegistrationTime;
    private Timestamp idDueTime;
    private int borrowedBook;

    public Reader() {
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getIdRegistrationTime() {
        return idRegistrationTime;
    }

    public void setIdRegistrationTime(Timestamp idRegistrationTime) {
        this.idRegistrationTime = idRegistrationTime;
    }

    public Timestamp getIdDueTime() {
        return idDueTime;
    }

    public void setIdDueTime(Timestamp idDueTime) {
        this.idDueTime = idDueTime;
    }

    public int getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(int borrowedBook) {
        this.borrowedBook = borrowedBook;
    }
}
