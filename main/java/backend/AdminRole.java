package backend;

import constants.FileNames;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AdminRole implements FileNames{
    private LibrarianUserDatabase database=new LibrarianUserDatabase(LIBRARIANS_FILENAME);

    public AdminRole() throws FileNotFoundException {
        this.database.readFromFile();
    }

    public void addLibrarian(String librarianId, String name, String email,String address, String phoneNumber) throws IOException
    {
    
         LibrarianUser u1= new LibrarianUser (librarianId,name,email,address,phoneNumber);
         database.insertRecord(u1);
     
    }
    public LibrarianUser[] getListOfLibrarians()
    {
        LibrarianUser [] arrayusers = new LibrarianUser[database.returnAllRecords().size()];
        return database.returnAllRecords().toArray(arrayusers);

    }
    public void removeLibrarian(String key)
    {
      if (this.database.contains(key))
          this.database.deleteRecord(key);
    }
    public void logout() throws IOException
    {
         this.database.saveToFile();
    }
}
