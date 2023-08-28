package backend;

import java.time.LocalDate;

public class StudentBook implements Information {
    
    private String studentId,bookId;
    private LocalDate borrowDate;

    public StudentBook(String studentId,String bookId,LocalDate date)
    {
        this.studentId=studentId;
        this.bookId=bookId;
        borrowDate=date;
    }
    public String lineRepresentation()
    {
        return studentId+","+bookId+","+borrowDate;
    }
    public String getSearchKey()
    {
         return studentId+","+bookId;
    }
    public String getStudentId()
    {
        return studentId;
    }
    public String getBookId()
    {
        return bookId;
    }
    public LocalDate getBorrowDate()
    {
        return borrowDate;
    }
}
