public class App {
    public static void main(String[] args) throws Exception {
        Author author1 = new Author("Nguyen Van A", "a@gmail.com",'m');
        Author author2 = new Author("Le Thi B", "b@gmail.com",'f');
        Author author3 = new Author("Nguyen Van C", "c@gmail.com",'f'); // Trung với tac gia 1

        Book book1 = new Book("Book One", new Author[] { author1, author3 }, 12.5, 10);
        Book book2 = new Book("Book Two", new Author[] { author2, author1 }, 15.0, 5);
        Book book3 = new Book("Book Three", new Author[] { author1, author3 }, 20.0, 7);

        Book[] books = new Book[] { book1, book2, book3 };

        Manager manager = new Manager(books);
        System.out.println("Unique authors: " + manager.getAuthorNames());
    }
}
