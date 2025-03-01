package gym;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;

public class FileWritingTest {
	  public static void main(String[] args) {
	        String fileName = "data.txt";

	        List<String> content = List.of("Zeile 1", "Zeile 3");

	     
	        try {
	            Files.write(Path.of(fileName), content);
	            System.out.println("Datei erfolgreich gespeichert!");
	            System.out.println("Dateipfad: " + Path.of(fileName).toAbsolutePath());

	        } catch (IOException e) {
	            System.out.println("Fehler beim Speichern der Datei: " + e.getMessage());
	        }
	    }
	}




