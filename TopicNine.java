import java.util.*;
import java.lang.*;

public class TopicNine {
  
  Scanner scan = new Scanner(System.in);

  void exerciseThreePointFive() {
    System.out.println("1. After the first writing pass");
    System.out.println("2. Divide by zero: the compiler might not know what the denominator is");
    System.out.println("3a. Run-time");
    System.out.println("3b. Compile-time");
    System.out.println("3c. Logic");
  }    

  void exerciseThreePointSix() {
    System.out.println("1. Adding print statements between calculations");
    System.out.println("2. Area not declared");
  }    
  
  public static void main(String args[]) {
    TopicNine go = new TopicNine();
    go.exerciseThreePointFive();
    go.exerciseThreePointSix();
  }  
}