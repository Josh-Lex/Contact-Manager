import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
  //This is so we can use the Input class
  InputTCF input = new InputTCF();
  //This is so we can use the IOmethods Class
  IOMethods io = new IOMethods();

  //Below is our Main Menu method.
  //This method takes in a path, but only to push it on to the next.
  public void CMMain(Path path) {
    System.out.println("Please select from the options below.");
    System.out.println("1. View contacts.");
    System.out.println("2. Add a new contact.");
    System.out.println("3. Search a contact.");
    System.out.println("4. Delete an existing contact.");
    System.out.println("5. Exit.");
    System.out.println("Enter an option (1, 2, 3, 4 or 5):");
    int choice = input.getInt(1, 5);
    //Depending on the user's choice we will use one of the methods.
    switch (choice) {
      case 1 -> viewContacts(path);   //Shows all contacts
      case 2 -> addContact(path);     //Appends a contact to the end.
      case 3 -> searchContact(path);  //Allows you to show a contact.
      case 4 -> deleteContact(path);  //Allows you to delete a contact.
      case 5 -> {                     //Ends program
        System.out.println("Exit");
        System.exit(0);
      }
    }


  }

  //This method ask the user if they want to return to the main menu.
  public void takeMeToMenu(Path path) {
    boolean userResponse = input.yesNo("Would you like to go back to menu");
    if (userResponse) {
      CMMain(path);
    }
  }

  //This method shows the contacts, using our IOMethods class method.
  public void viewContacts(Path path) {
    System.out.println("Name | Phone number\n" +
      "---------------");
    //Prints everything to the console by turning it into a list, and using a for loop to print each line to the console.
    io.printToConsole(path);
    //Ask if you want to return to main menu.
    takeMeToMenu(path);
  }

  //For adding contacts or "appending"
  public void addContact(Path path) {
    System.out.println("Please enter the name of your contact");
    String contactName = input.getString();
    System.out.println("Please enter phone number for " + contactName);
    String phoneNumber = String.valueOf(input.getLong());
    System.out.println("Great, we have added your contact");
    //Below concats the name and number, and then it appends it to the contacts file
    try {
      Files.writeString(path, contactName + " | " + phoneNumber + "\n", StandardOpenOption.APPEND);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    //ask if we want to return to main menu
    takeMeToMenu(path);
  }

  public void searchContact(Path path) {
    //This creates a list of the current contacts from the contacts.txt file.
    List<String> currentList = new ArrayList<>();
    try {
      currentList = Files.readAllLines(path);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    //This below searches the currentList for the index of the search
    //Currently is case sensitive and have to be at the beginning.
    //TODO Make it search regardless of case.
    System.out.println("Please enter the contact's name.");
    System.out.println("THIS IS CASE SENSITIVE");
    String search = input.getString();
    //If the boolean is found we display that contact.
    //TODO Make it so if the contact is not found, tell the user, and ask if they want to try again or return to main menu?
    boolean found = false;
    for (int i = 0; i < currentList.size(); i++) {

      if (currentList.get(i).startsWith(search)) {
        System.out.println("Name | Phone number\n" +
          "---------------");
        found = true;
        System.out.println(currentList.get(i).toString());
      }
    }
    if (!found) {
      System.out.println("Contact not found.");
    }
    takeMeToMenu(path);
  }

  public void deleteContact(Path path) {
    //This creates a list of the current contacts from the contacts.txt file.
    List<String> currentList = new ArrayList<>();
    try {
      currentList = Files.readAllLines(path);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    //This below searches the currentList for the index of the search
    //Currently is case sensitive and have to be at the beginning.
    //TODO Make it search regardless of case.
    System.out.println("Please enter the contact's name.");
    System.out.println("THIS IS CASE SENSITIVE");
    String search = input.getString();
    //If the boolean is found we display that contact.
    //TODO Make it so if the contact is not found, tell the user, and ask if they want to try again or return to main menu?
    boolean found = false;
    for (int i = 0; i < currentList.size(); i++) {
      if (currentList.get(i).startsWith(search)) {
        System.out.println("Contact Removed.");
        found = true;
        //Removes the index from the search.
        currentList.remove(i);
        //Below writes the file, with the new list.
        try {
          Files.write(path, currentList);
        } catch (IOException ioe) {
          ioe.printStackTrace();
        }
      }
    }
    if (!found) {
      System.out.println("Contact not found.");
    }
    takeMeToMenu(path);
  }

  public static void main(String[] args) {

    Path contactsDirectory = Paths.get("src/data");
    Path contactsFile = Paths.get(String.valueOf(contactsDirectory), "contacts.txt");
    Main cm = new Main();

    cm.CMMain(contactsFile);
//    List<String> testList = new ArrayList<>();
//    testList.add("Bruce Wayne | 1235559817\n");
//    testList.add("Clark Kent | 1118883245\n");
//    testList.add("Lamar Davis | 9997778790\n");
//    System.out.println(testList.indexOf("Bruce Wayne | 1235559817\n"));
//    testList.contains('Bruce');
//    boolean found;
//    for (int i = 0; i < testList.size(); i++ ) {
//
//      if (testList.get(i).startsWith("Bruce")) {
//        found = true;
//        System.out.println(testList.get(i).toString());
//      }
//    }

    // Create a File

//       try {
//           if (Files.notExists(contactsFile)){
//               Files.createFile(contactsFile);
//           }
//       } catch (IOException ioe) {
//           ioe.printStackTrace();
//       }


  }
}
