import java.io.IOException;
import java.nio.file.*;

public class Main {

  InputTCF input = new InputTCF();

  IOmethods io = new IOmethods();


  public void CMMain(Path path) {
    System.out.println("Please select from the options below.");
    System.out.println("1. View contacts.");
    System.out.println("2. Add a new contact.");
    System.out.println("3. Search a contact.");
    System.out.println("4. Delete an existing contact.");
    System.out.println("5. Exit.");
    System.out.println("Enter an option (1, 2, 3, 4 or 5):");
    int choice = input.getInt(1,5);
    switch (choice) {
      case 1 -> viewContacts(path);
      case 2 -> addContact(path);
      case 3 -> searchContact(path);
      case 4 -> deleteContact(path);
      case 5 -> {
        System.out.println("Exit");
        System.exit(0);
      }
    }


  }

  public void takeMeToMenu(Path path){
    Boolean userResponse = input.yesNo("Would you like to go back to menu");
    if (userResponse){
      CMMain(path);
    }
  }

  public void viewContacts(Path path) {
    System.out.println("Name | Phone number\n" +
            "---------------");
    io.printToConsole(path);
    takeMeToMenu(path);
  }

  public void addContact(Path path) {
    System.out.println("Please enter the name of your contact");
    String contactName = input.getString();
    System.out.println("Please enter phone number for " + contactName);
    String phoneNumber = String.valueOf(input.getLong());
    System.out.println("Great, we have added your contact");
    try {
            Files.writeString(path, contactName + " | " + phoneNumber + "\n", StandardOpenOption.APPEND);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    takeMeToMenu(path);
  }
  public void searchContact(Path path) {
    System.out.println("search contacts");
    takeMeToMenu(path);
  }

  public void deleteContact(Path path) {
    System.out.println("delete contact");
    takeMeToMenu(path);
  }

  public static void main(String[] args) {

    Path contactsDirectory = Paths.get("src/data");
    Path contactsFile = Paths.get(String.valueOf(contactsDirectory), "contacts.txt");
    Main cm = new Main();

    cm.CMMain(contactsFile);



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
