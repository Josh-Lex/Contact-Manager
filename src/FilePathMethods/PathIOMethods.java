package FilePathMethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class PathIOMethods {
  //This is so we can use the Input class
  InputTCF input = new InputTCF();

  public void printToConsole(Path pathToFile) {
    List<String> currentList = new ArrayList<>();
    try {
      currentList = Files.readAllLines(pathToFile);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    for (String line : currentList) {
      System.out.println(line);
    }
  }
//Verify
  //For adding contacts or "appending"
  //Make sure this is the path to the file you are working with
  public void addLineToFile(Path path) {
    //This creates a list of the current Lines from the .txt file.
    //To check the values.
    List<String> currentList = new ArrayList<>();
    try {
      currentList = Files.readAllLines(path);
//      System.out.println(currentList);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    //You could put things you want to check here
    System.out.println("Search parameter");
    String searchString = "Search";
    System.out.println("Please enter thing for " + searchString);
    String extraInfoToCollect = "Extra info";

    //Below iterates to check the value.
    boolean found = false;
    for (int i = 0; i < currentList.size(); i++) {

      if (currentList.get(i).startsWith(searchString)) {
        //Stuff that goes here happens if we find something that STARTS with out search, but it is case sensitive unless we store everything as uppercase or lowercase to check.
        found = true;
        System.out.println(currentList.get(i).toString());
        System.out.println("This Line already exist");
        System.out.println("Would you like to overwrite this?");
        boolean ask = input.yesNo();
        //This ask the user if they want to check or keep the data they already have.
        if (ask) {
          //If yes change the data then we remove what was originally there.
          currentList.remove(i);
//          System.out.println(currentList);
        } else {
          //Here we ask if you still want to create the contact if the ask was a No, to overwrite. This is just if we still want to append.
          System.out.println("Do you still want to create this Line?");
          ask = input.yesNo();
          //If yes we We continue(notice the !) but if no then we go back to where ever
          if (!ask) {
//            NewMethod(path);
            System.out.println("Going to next method...");
          }
          //Close !ask
        } // close else from first ask

      } // close if we find the thing we are searching
    }// close for loop
    //Below overwrites data
    try {
      Files.write(path, currentList);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    //Below concats the name and number, and then it appends it to the contacts file
//  Phone with dashes change
    //Below appends the data assuming we don't exit from the method earlier in the !ask
    System.out.println("Great, we have added your contact");
    try {

      Files.writeString(path, "Thing we added.", StandardOpenOption.APPEND);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    //This happens at the end after we append what we wanted.
//   nextMethod(path);
    System.out.println("On to next method after appending");
  }


}
