package backend;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

 abstract class Database {
    
      protected ArrayList<Information> records = new ArrayList<>();
    protected String filename;

    public Database ()
    {
        
    }
    public abstract Information createRecordFrom(String line);
    public ArrayList<Information> returnAllRecords()
    {
        return records;
    }
    public void readFromFile() throws FileNotFoundException {
        try {
            File file = new File(filename);
            Scanner sc= new Scanner(file);
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                records.add(createRecordFrom(line));
            }
            sc.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("An error occurred");
        }
    }
    public boolean contains(String key )
    {
        for (int i=0; i<records.size();i++) {
            if ( records.get(i).getSearchKey().equals(key))
                return true;
        }
        return false;
    }
    public Information getRecord(String key)
    {
        for (Information record : records) {
            if (record.getSearchKey().equals(key))
                return record;
        }
        return null;
    }
    public void insertRecord(Information record)
    {
        records.add(record);
    }
    public void deleteRecord(String key)
    {
        for (int i=0; i< records.size();i++)
        {
            if (records.get(i).getSearchKey().equals(key))
                returnAllRecords().remove(i);
        }
    }
    public void saveToFile() throws IOException {
        try{
            File file = new File(filename);
            FileWriter filewriter = new FileWriter(file,false);
            for (Information record : records) {
                filewriter.write(record.lineRepresentation());
                filewriter.write("\n");
            }
            filewriter.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
   
}
