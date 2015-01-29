import java.util.*;
import java.lang.*;

public class TopicEight {
  
  Scanner scan = new Scanner(System.in);
  
  void exerciseNinePointFour() {
    System.out.println("2. extends SuperClass");
    System.out.println("3. It calls the superclass's constructor");
    System.out.println("4. It calls the superclass's method of the same name");
  }
  
  void exerciseNinePointFive() {
    System.out.println("1. A class that doesn't have to have a definition for all methods");
    System.out.println("2. So that we don't need to implement certain things, forcing override");
    System.out.println("3. It cannot be overriden");
  }

  void exerciseThreePointTwo() {
    System.out.println("25. x.y is a package, z is a class");
    System.out.println("26. Imports all classes in package");
  }
  
  void getBank() {
    /* Write the BankAccount, CheckingAccount, and SavingsAccount classes
     * as instructed */
    CheckingAccount harry = new CheckingAccount(1000.);
    harry.withdraw(300);
    harry.deposit(500);
    harry.withdraw(100);
    System.out.println("Harry balance: " + harry.getBalance());
    CheckingAccount niall = new CheckingAccount(500.);
    niall.transfer(100, harry);
    System.out.println("Harry balance: " + harry.getBalance());
    SavingsAccount zayn = new SavingsAccount(2000., 4.2);
    zayn.withdraw(1000);
    System.out.println("Zayn balance: " + zayn.getBalance());
    zayn.withdraw(1000); // should not be allowed
    System.out.println("Zayn balance: " + zayn.getBalance());
    zayn.addInterest();
    System.out.println("Zayn balance: " + zayn.getBalance());
  }
  
  void doComputerStudent() {
    /* write ComputerStudent.java
     * 
     * ComputerStudent extends Student and adds the following variables:
     * int myPeriod, String myComputer, int myID, and an ArrayList of Double myGrades
     *
     * ComputerStudent adds the following methods:
     * setPeriod (to assign myPeriod a value), setComputer (to name myComputer), 
     * setID, and addGrade (which adds a new grade to the end of the ArrayList
     *
     * Also add methods to get values: getPeriod, getComputer, getID, and getAverage
     *
     * Have fun!       */
    
    System.out.println("Uncomment to grade!");
    /*
    ComputerStudent cs1 = new ComputerStudent(52.4, "Miley Cyrus");
    System.out.println(cs1.getName());
    cs1.setAverage(47.6);
    System.out.println(cs1.getAverage());
    cs1.setPeriod(8);
    System.out.println(cs1.getPeriod());
    cs1.setID(4212);
    System.out.println(cs1.getID());
    */
  }
  
  void hangman() {
    // complete class Hangman.java as instructed
    // and finish it below:
    
    // First, make an instance of type Hangman     */

    
    
    // Now, have the user enter the word to be guessed

    
    // Now, run the game while the number of turns is more than 0 AND the user has not won

    
    
    
    
    /* Finally, if the player lost, print a message making fun of them and provide the correct word
     * If the player won, print a congratulatory message      */

  
  
  
  
    
    
    // Done!
  }
  
public static void main(String args[]) {
    TopicEight go = new TopicEight();
    go.exerciseNinePointFour();
    go.exerciseNinePointFive();
    go.exerciseThreePointTwo();
    go.getBank();
    go.doComputerStudent();
    go.hangman();
  }  
}