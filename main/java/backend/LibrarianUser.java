
package backend;

public class LibrarianUser implements Information {
    
    private String librarianId,name,email,address,phoneNumber;

    public LibrarianUser(String librarianId,String name,String email,String address,String phoneNumber)
    {
        this.librarianId=librarianId;
        this.name=name;
        this.email=email;
        this.address=address;
        this.phoneNumber = phoneNumber;
    }

    public String lineRepresentation()
    {
        return librarianId+","+name+"," +email+ "," +address+ "," +phoneNumber;
    }
    public String getSearchKey()
    {
        return librarianId;
    }
    
}
