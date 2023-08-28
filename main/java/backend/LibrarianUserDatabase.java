
package backend;

import constants.FileNames;


 class LibrarianUserDatabase extends Database implements FileNames {
     public LibrarianUserDatabase (String filename)
    {
        this.filename=filename;
    }
    @Override
    public LibrarianUser createRecordFrom(String line)
    {
        String [] data = line.split(",");
        LibrarianUser user= new LibrarianUser(data[0],data[1],data[2],data[3],data[4]);
        return user;
    }
    
}
