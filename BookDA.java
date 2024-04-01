import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.*;

public class BookDA {

    public HashMap<String, Book> readBooks(String filename, HashMap<String, Author> authors) {
        HashMap<String, Book> books = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Book book = new Book();
                book.setIsbn(data[0]);
                book.setTitle(data[1]);

                //where to access, sequence diagram

                Author author = authors.get(data[2]);
                if (author != null) {
                    book.setAuthor(author);
                }

                books.put(book.getIsbn(), book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}
