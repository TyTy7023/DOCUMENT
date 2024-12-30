using System;
using System.Collections.Generic;

public class BookView
{
    public void DisplayBookList(List<Book> books)
    {
        Console.WriteLine("Book List:");
        foreach (var book in books)
        {
            Console.WriteLine(book.GetDetails());
        }
    }

    public void DisplayBookDetails(Book book)
    {
        if (book != null)
        {
            Console.WriteLine("Book Details:");
            Console.WriteLine(book.GetDetails());
        }
        else
        {
            Console.WriteLine("Book not found.");
        }
    }

    public void ShowMessage(string message)
    {
        Console.WriteLine(message);
    }

    public Book GetBookInput()
    {
        var book = new Book();
        Console.Write("Enter Book ID: ");
        book.Id = int.Parse(Console.ReadLine());
        Console.Write("Enter Title: ");
        book.Title = Console.ReadLine();
        Console.Write("Enter Author: ");
        book.Author = Console.ReadLine();
        Console.Write("Enter Price: ");
        book.Price = double.Parse(Console.ReadLine());
        Console.Write("Enter ISBN: ");
        book.ISBN = Console.ReadLine();
        Console.Write("Enter Quantity: ");
        book.Quantity = int.Parse(Console.ReadLine());
        return book;
    }

    public int GetBookIdInput()
    {
        Console.Write("Enter Book ID: ");
        return int.Parse(Console.ReadLine());
    }
}
