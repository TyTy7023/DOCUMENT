public class book {
    final String ISBN, title, authors, publisher, year; 
    private boolean status;

    //public book(){};
    // constructor 
    public book(String ISBN, String title, String authors, String publisher, String year)
    {
        this.ISBN=ISBN;
        this.authors=authors;
        this.title=title;
        this.publisher=publisher;
        this.year=year;
        this.status=true;
    } 
    // setter and getter
    public void setStatus(boolean status)
    {
        this.status=status;
    }
    public boolean getStatus()
    {
        return this.status;
    }
    // output Information of books
    public void infoBook()
    {
        System.out.println("The book of name: " + ISBN);
        System.out.println("The book of title: " + title);
        System.out.println("The book of authors: " + authors);
        System.out.println("The book of publisher: " + publisher);
        System.out.println("The book of publishing year: " + year);
        System.out.print("The book of status: ");
        if(status) System.out.println("available");
        else System.out.println("loaned");
    }
}
