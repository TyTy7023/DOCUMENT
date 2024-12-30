using System.Collections.Generic;

public class BookModel
{
    private List<Book> books = new List<Book>();

    public void AddBook(Book book)
    {
        books.Add(book);
    }

    public void RemoveBook(int id)
    {
        books.RemoveAll(b => b.Id == id);
    }

    public void UpdateBook(Book book)
    {
        var existingBook = books.Find(b => b.Id == book.Id);
        if (existingBook != null)
        {
            existingBook.Title = book.Title;
            existingBook.Author = book.Author;
            existingBook.Price = book.Price;
            existingBook.ISBN = book.ISBN;
            existingBook.Quantity = book.Quantity;
        }
    }

    public List<Book> GetAllBooks()
    {
        return books;
    }

    public Book FindBookById(int id)
    {
        return books.Find(b => b.Id == id);
    }
}
