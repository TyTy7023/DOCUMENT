public class Book {
    private String name;
    private Author[] author;
    private double price;
    private int qty;

    public Book(String name, Author[] author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = 0;
    }
    public Book(String name, Author[] author, double price, int qty) {
        this.name = name;  
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Author[] getAuthor() {
        return this.author;
    }
    public String getAuthorName(){
        String authorName = "(";
        for (int i = 0; i < this.author.length; i++) {
            authorName += this.author[i].getName();
            if (i < this.author.length - 1) {
                authorName += ", ";
            }
        }
        return authorName + ")";
    }

    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return this.qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Book[name = " + this.name + ", authors = " + getAuthorName() + ", price = " + this.price + ", qty = " + this.qty + "]";
    }
}
