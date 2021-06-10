import data.InputTCF;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

  InputTCF input = new InputTCF();

  public void CMMain() {
    System.out.println("Please select from the options below.");
    System.out.println("1. View contacts.");
    System.out.println("2. Add a new contact.");
    System.out.println("3. Search a contact.");
    System.out.println("4. Delete an existing contact.");
    System.out.println("5. Exit.");
    System.out.println("Enter an option (1, 2, 3, 4 or 5):");
    int choice = input.getInt(1,5);
    switch (choice) {
      case 1 -> viewContacts();
      case 2 -> addContact();
      case 3 -> searchContact();
      case 4 -> deleteContact();
      case 5 -> {
        System.out.println("Exit");
        System.exit(0);
      }
    }


  }

  public void viewContacts() {
    System.out.println("View contacts");
  }

  public void addContact() {
    System.out.println("Add contact");
  }
  public void searchContact() {
    System.out.println("search contacts");
  }

  public void deleteContact() {
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
