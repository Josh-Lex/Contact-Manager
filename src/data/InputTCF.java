package data;


import java.util.Scanner;

public class InputTCF {

  private Scanner scanner = new Scanner(System.in);
  //Below was the way Jay did it, but I'm not sure if what effects it can have?.
  //The rest of the code works with it either way
// private Scanner scanner;
//  public InputOtherWay(){
//    this.scanner = new Scanner(System.in);
//  }


  public String getString() {
    String outPut = scanner.nextLine();
    return outPut;
  }

  public String getString(String prompt) {
    System.out.println(prompt);
    String outPut = scanner.nextLine();
    return outPut;
  }

  public boolean yesNo() {
//    Scanner why = new Scanner(System.in);
    System.out.println("Press enter y or yes to continue");
    String outPut = scanner.nextLine();
    if (outPut.equalsIgnoreCase("y") || outPut.equalsIgnoreCase("yes")) {
      return true;
    } else {
      return false;
    }
  }

  public boolean yesNo(String prompt) {
    System.out.println(prompt);
    String outPut = scanner.nextLine();
    if (outPut.equalsIgnoreCase("y") || outPut.equalsIgnoreCase("yes") || outPut.equalsIgnoreCase("ye") || outPut.equalsIgnoreCase("yea") || outPut.equalsIgnoreCase("ya")) {
      return true;
    } else {
      return false;
    }
  }

  public int getInt(int min, int max) {
    try {
      //If we don't get an exception, we return tryPut
      int tryPut = Integer.valueOf(getString());
      if (tryPut >= min && tryPut <= max) {
        return tryPut;
      } else {
        System.out.printf("%d is not an option.\n",tryPut);
        System.out.println("Please try again.");
        return getInt(min, max);
      }
    } catch (NumberFormatException nfe) {
      //If we get an exeception, we rerun getInt, if it throws another exception we re-run again over and over.
      System.out.println("That was an invalid input please input an INTEGER.");
      return getInt();
    }

  }

// Refactored to use try and catch to find errors incase a user doesn't put an Integer in.
  public int getInt() {
      try {
        //If we don't get an exception, we return tryPut
        int tryPut = Integer.valueOf(getString());
        return tryPut;
      } catch (NumberFormatException nfe) {
        //If we get an exeception, we rerun getInt, if it throws another exception we re-run again over and over.
        System.out.println("That was an invalid input please input an INTEGER.");
        return getInt();
        }
      }

  public int getInt(String prompt) {
    System.out.println(prompt);
    int outPut = scanner.nextInt();
    scanner.nextLine();
    return outPut;
  }

  public double getDouble(double min, double max) {
    System.out.printf("enter a number between %f, and %f\n", min, max);
    double outPut = scanner.nextDouble();
    scanner.nextLine();
    if (outPut >= min && outPut <= max) {
      return outPut;
    } else {
      return getDouble(min, max);
    }
  }

  public double getDouble() {
    try {
      //If we don't get an exception, we return tryPut
      double tryPut = Double.valueOf(getString());
      return tryPut;
    } catch (NumberFormatException nfe) {
      //If we get an exeception, we rerun getDouble, if it throws another exception we re-run again over and over.
      System.out.println("That was an invalid input please input an INTEGER.");
      return getDouble(); //Make sure to not JUST RUN the method because it will stay inside of each other not get a new value, we want to RETURN so it stops this block and starts a new block of getDouble.
    }
  }

  public double getDouble(String prompt) {
    System.out.println(prompt);
    double outPut = scanner.nextDouble();
    return outPut;
  }
  public int getBinary() {
    String outPut = Integer.toBinaryString(getInt());
    int intPut = Integer.valueOf(outPut);
    return intPut;
  }

  public int fromBinary() {
    String outPut = Integer.toString(getInt());
    int intPut =   Integer.parseInt(outPut,2);
    return intPut;
  }

  public String getHex() {
    String outPut = Integer.toHexString(getInt());
    return outPut;
  }

  public int fromHex() {
    String outPut = getString();
    int intPut =   Integer.parseInt(outPut,16);
    return intPut;
  }



}
