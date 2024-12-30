import java.util.HashSet;
import java.util.Set;

public class Manager {
    private Book[] books;
    private Author[] authors;

    public Manager(Book[] books) {
        this.books = new Book[books.length];
        for (int i = 0; i < books.length; i++) {
            this.books[i] = new Book(books[i].getName(), books[i].getAuthor(), books[i].getPrice(), books[i].getQty());
        }
        this.authors = uniqueAuthors();
    }

    public String getAuthorNames() {
        StringBuilder authorNames = new StringBuilder("(");
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] != null) {
                authorNames.append(authors[i].getName());
                if (i < authors.length - 1) {
                    authorNames.append(", ");
                }
            }
        }
        return authorNames.append(")").toString();
    }

    public Author[] uniqueAuthors() {
        Set<Author> uniqueAuthorsSet = new HashSet<>();

        for (Book book : books) {
            for (Author author : book.getAuthor()) {
                uniqueAuthorsSet.add(new Author(author.getName(), author.getEmail(), author.getGender())); // Add unique authors
            }
        }
        return uniqueAuthorsSet.toArray( new Author[uniqueAuthorsSet.size()]);
    }
}
