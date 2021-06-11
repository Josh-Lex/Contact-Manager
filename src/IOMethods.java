import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IOMethods {

  public void printToConsole (Path pathToFile){
    List<String> currentList = new ArrayList<>();
    try {
      currentList = Files.readAllLines(pathToFile);
    } catch (IOException ioe){
      ioe.printStackTrace();
    }
    for (String line: currentList) {
      String [] lineContact = line.split("\\.");
      String lineName = lineContact[0];
      String lineNumber = lineContact[1];
      while (lineName.length() < 15) {
        lineName += " ";
      }
      while (lineNumber.length() < 15) {
        lineNumber += " ";
      }
      String lineSout = String.format("%2s |%s %s|", lineName, "", lineNumber);
//      String lineSout = String.format("%s %5s | %s", lineName, "", lineNumber);

      System.out.println(lineSout);
    }
    System.out.println("---------------------------------");

//    for (String line: currentList) {
//      String [] lineContact = line.split(" | ");
//      String firstName = lineContact[0];
//      String lastName = lineContact[1];
//      String phoneNum = lineContact[2];

//
////      System.out.println("this is line number" + lineNumber);
//      System.out.println(lineSout);
//    }
  }


}
