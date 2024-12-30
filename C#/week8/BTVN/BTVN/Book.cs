public class Book
{
    public int Id { get; set; }
    public string Title { get; set; }
    public string Author { get; set; }
    public double Price { get; set; }
    public string ISBN { get; set; }
    public int Quantity { get; set; }

    public string GetDetails()
    {
        return $"ID: {Id}, Title: {Title}, Author: {Author}, Price: {Price:C}, ISBN: {ISBN}, Quantity: {Quantity}";
    }
}
