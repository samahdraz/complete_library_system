package backend;

import java.time.LocalDate;
import constants.FileNames;



class StudentBookDatabase extends Database implements FileNames {
    
     public StudentBookDatabase(String filename) {
        this.filename=filename;
    }
    @Override
    public StudentBook createRecordFrom(String line) {
        String[] data = line.split(",");
        StudentBook user = new StudentBook(data[0], data[1], LocalDate.parse(data[2]));
        return user;
    }
    
}
