import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;




public class AuthorDA {

    public HashMap<String, Author> readAuthors(String filename) {
        HashMap<String, Author> authors = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Author author = new Author();
                author.setName(data[0]);
                author.setBio(data[1]);
                authors.put(author.getName(), author);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authors;
    }
}