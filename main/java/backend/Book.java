
package backend;

public class Book implements Information {
     private String id,title,authorName,publisherName;
    private int quantity;

    public Book(String id, String title, String authorName, String publisherName, int quantity)
    {
        this.id=id;
        this.title=title;
        this.authorName=authorName;
        this.publisherName=publisherName;
        this.quantity=quantity;
    }
    public int getQuantity()
    {
        return this.quantity;
    }
    public void setQuantity(int q)
    {
        this.quantity=q;
    }
    public String lineRepresentation()
    {
        return  id+","+title+"," +authorName+ "," +publisherName+ "," +quantity;
    }
     public String getSearchKey()
     {
         return this.id;
     }
}
