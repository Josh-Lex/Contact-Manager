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
      case 1 -> viewContacts(Path path);
      case 2 -> addContact(Path path);
      case 3 -> searchContact(Path path);
      case 4 -> deleteContact(Path path);
      case 5 -> {
        System.out.println("Exit");
        System.exit(0);
      }
    }


  }

  public void viewContacts(Path path) {
    System.out.println("View contacts");
  }

  public void addContact(Path path) {
    System.out.println("Please enter the name of your contact");
    String contactName = input.getString();
    System.out.println("Please enter phone number for " + contactName);
    String phoneNumber = String.valueOf(input.getInt());
    try {
            Files.writeString(path, contactName + " | " + phoneNumber + "\n", StandardOpenOption.APPEND);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
  }
  public void searchContact(Path path) {
    System.out.println("search contacts");
  }

  public void deleteContact(Path path) {
    System.out.println("delete contact");
  }

  public static void main(String[] args) {

    Path contactsDirectory = Paths.get("src/data");
    Path contactsFile = Paths.get(String.valueOf(contactsDirectory), "contacts.txt");
    Main cm = new Main();
    cm.CMMain();


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
