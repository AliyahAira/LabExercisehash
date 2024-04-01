import java.util.*;

public class BookReport {

    public static void main(String[] args) {
        AuthorDA authorDA = new AuthorDA();
        HashMap<String, Author> authors = authorDA.readAuthors("Author.csv");

        BookDA bookDA = new BookDA();
        HashMap<String, Book> books = bookDA.readBooks("Book.csv", authors);

        for (Book book : books.values()) {
            System.out.println(book.getIsbn() + " " + book.getTitle());
            Author author = book.getAuthor();
            if (author != null) {
                System.out.println("\t" + author.getName() + " - " + author.getBio() + "\n");
            }
        }
    }
}
