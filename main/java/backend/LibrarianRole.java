package backend;

import constants.FileNames;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class LibrarianRole implements FileNames{
    private BookDatabase booksDatabase= new BookDatabase(BOOKS_FILENAME);
    private StudentBookDatabase sBDatabase;

    public LibrarianRole() throws FileNotFoundException {
            booksDatabase.readFromFile();      
        this.sBDatabase=new StudentBookDatabase(STUDENTSBOOKS_FILENAME);
        sBDatabase.readFromFile();
    }

    public void addBook(String id, String title, String authorName, String publisherName, int quantity)
    {
        if (booksDatabase.contains(id))
            System.out.println("Used ID");
        else
        {
            Book u1= new Book (id,title,authorName,publisherName,quantity);
            booksDatabase.insertRecord(u1);
        }
    }
    public Book[] getListOfBooks()
    {
        Book [] arrayusers = new Book[booksDatabase.returnAllRecords().size()];
        return booksDatabase.returnAllRecords().toArray(arrayusers);
    }
    public StudentBook[] getListOfBorrowingOperations()
    {
        StudentBook [] arrayusers = new StudentBook[sBDatabase.returnAllRecords().size()];
        return sBDatabase.returnAllRecords().toArray(arrayusers);
    }
    public int borrowBook(String studentId, String bookId,LocalDate borrowDate) throws IOException {
        Book b = (Book) booksDatabase.getRecord(bookId);
        if (sBDatabase.contains(studentId+","+bookId))
            return 1;
        if (b.getQuantity()==0)
            return 0;
        b.setQuantity(b.getQuantity()-1);
        StudentBook s= new StudentBook(studentId,bookId,borrowDate);
        sBDatabase.insertRecord(s);
        //sBDatabase.saveToFile();
        return 2;
    }
    public double returnBook(String studentId, String bookId, LocalDate returnDate) throws IOException {
         Book b = (Book) booksDatabase.getRecord(bookId);
        b.setQuantity(b.getQuantity()+1);
        StudentBook s = (StudentBook) sBDatabase.getRecord(studentId+","+bookId);
        sBDatabase.deleteRecord(studentId + "," + bookId);
        //sBDatabase.saveToFile();
        Period p = Period.between(s.getBorrowDate(),returnDate);
        long days=p.getDays()+p.getMonths()*30;
        if (days > 7)
            return (days - 7) * 0.5;
        else
            return 0;
    }
    public void logout() throws IOException
    {
        this.booksDatabase.saveToFile();
        this.sBDatabase.saveToFile();
    }
}
