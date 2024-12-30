using System;
using System.Collections.Generic;

namespace BTVN
{
    public class BookController
    {
        private List<Book> books;
        private int nextId;

        public BookController()
        {
            books = new List<Book>();
            nextId = 1;
            books.Add(new Book { Id = nextId++, Title = "Sample Book", Author = "Author Name" });
        }

        public Book GetBookInput()
        {
            Console.WriteLine("Enter book title:");
            string title = Console.ReadLine();
            Console.WriteLine("Enter book author:");
            string author = Console.ReadLine();

            if (!string.IsNullOrEmpty(title) && !string.IsNullOrEmpty(author))
            {
                return new Book { Id = nextId++, Title = title, Author = author };
            }

            return null;
        }

        public int GetBookIdInput()
        {
            Console.WriteLine("Enter book ID:");
            if (int.TryParse(Console.ReadLine(), out int id))
            {
                return id;
            }

            return -1;
        }

        public void AddBook(Book book)
        {
            books.Add(book);
        }

        public void DeleteBook(int id)
        {
            var book = books.Find(b => b.Id == id);
            if (book != null)
            {
                books.Remove(book);
            }
        }

        public void UpdateBook(int id, Book updatedBook)
        {
            var book = books.Find(b => b.Id == id);
            if (book != null)
            {
                book.Title = updatedBook.Title;
                book.Author = updatedBook.Author;
            }
        }

        public List<Book> GetAllBooks()
        {
            return books;
        }

        public void ShowBookDetails(int id)
        {
            var book = books.Find(b => b.Id == id);
            if (book != null)
            {
                Console.WriteLine($"ID: {book.Id}, Title: {book.Title}, Author: {book.Author}");
            }
            else
            {
                Console.WriteLine("Book not found!");
            }
        }
    }

    public class Book
    {
        public int Id { get; set; }
        public string Title { get; set; }
        public string Author { get; set; }

        public string GetDetails()
        {
            return $"ID: {Id}, Title: {Title}, Author: {Author}";
        }
    }
}
