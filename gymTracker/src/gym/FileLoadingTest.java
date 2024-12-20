package gym;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileLoadingTest {
	  public static void main(String[] args) {
	        String fileName = "data.txt";

	        try {
	            List<String> lines = Files.readAllLines(Path.of(fileName));
	            for (String line : lines) {
	                System.out.println(line);
	            }
	        } catch (IOException e) {
	            System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
	        }
	    }
}
