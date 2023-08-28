package backend;

import constants.FileNames;

import java.lang.*;

 class BookDatabase extends Database implements FileNames{
     public BookDatabase (String filename)
    {
        this.filename=filename;
    }
    @Override
    public Book createRecordFrom(String line)
    {
        String [] data = line.split(",");
        Book user= new Book(data[0],data[1],data[2],data[3],Integer.parseInt(data[4]));
        return user;
    }
    
}
