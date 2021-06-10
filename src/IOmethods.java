import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IOmethods {

  public void printToConsole (Path pathToFile){
    List<String> currentList = new ArrayList<>();
    try {
      currentList = Files.readAllLines(pathToFile);
    } catch (IOException ioe){
      ioe.printStackTrace();
    }
    for (String line: currentList) {
      System.out.println(line);
    }
  }


}
