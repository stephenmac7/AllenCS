import java.util.*;
import java.lang.*;

public class TopicSeven {
  
  Scanner scan = new Scanner(System.in);

  void exerciseElevenPointOne() {
    System.out.println("5. Raises 2 to the power of 5");
    System.out.println("6. Inifinite execution");
  }    

  void projectFiveDashSix() {
    // turn in your Book and Patron java files through Gaggle
  }
  
  public String reversedWords(String s) {
    int len = s.length();
    if (len > 1) {
      String head = s.substring(0, 1);
      String tail = s.substring(1, len);
      return reversedWords(tail) + head;
    } else {
      return s;
    }
  }
  
  private static double raisedPower(int a, int b) {
    // this method finds a^b for positive values of b
    // modify this method so it finds a^b for negative values of b as well
    if(b <= 0) {
      if (b == 0) {
        return 1;
      }
      else {
        return 1 / raisedPower(a, -b);
      }
    }
    else {
     return a * raisedPower(a, b - 1);
    }
  }
  
  public static int findFactorial(int a) {
    // write a method that finds the factorial of an integer
    // the factorial is the product of all the digits less than a number
    // Quick version: factorial n = if n == 0 then 1 else n * factorial (n - 1)
    if (a == 0)
      return 1;
    else
      return a * findFactorial(a - 1);
  }
  
  double averageValues(int[] a) {
    // write a method that accepts the array of integers
    // and returns the average of all the numbers in the array as a double
    int sum = 0;
    for(int i : a) {
      sum += i;
    }
    return sum / a.length;
  }
  
  void nutrition() {
    // complete the NutritionFacts class and upload it to Gaggle
    System.out.println("Uncomment to test!");
    /*
    NutritionFacts nf = new NutritionFacts(17.0, 0.0, 140.0, 6.0, 8.0);   // for peanut butter
    double calories = 0.0;
    calories = nf.calories();
    System.out.println(calories);
    double fat = 0.0;
    fat = nf.fat();
    System.out.println(fat);
    nf.label(); // this will print out the label
    */
  }
  
  void hanna() {
    // complete the HannaPark class and upload it to Gaggle
    System.out.println("Uncomment to test!");
    /*
    HannaPark hp1 = new HannaPark(true, 3);
    HannaPark hp2 = new HannaPark(false, 5);
    System.out.println("Uncomment the hp methods to grade!");
    int charge1 = 0;
    int charge2 = 0;
    charge1 = hp1.cost();
    charge2 = hp2.cost();
    System.out.println(charge1 + " " + charge2);
    */
  }
  
  void dcl() {
    // complete the DCLDining class and upload it to Gaggle
    System.out.println("Uncomment to test!");
    /*
    DCLDining family1 = new DCLDining("Bieber", 2019);
    DCLDining family2 = new DCLDining("Kardashian", 8121);
    System.out.println("Uncomment the dcl methods to grade!");
    String dine1 = new String(family1.nameAssign);
    String dine2 = new String(family2.nameAssign);
    family1.displayRest();
    family2.displayRest();
    */
  }
  
  void pt() {
    // complete the ParkTickets class and upload it to Gaggle
    System.out.println("Uncomment to test!");
    /*
    ParkTickets a = new ParkTickets(342);
    ParkTickets b = new ParkTickets(921);
    ParkTickets c = new ParkTickets(223);
    ParkTickets d = new ParkTickets(276);
    a.oneDayTwoPark();
    b.weekdayAnnual();
    c.annual();
    d.afternoonAnnual();
    int h = 10;
    String s = new String("SS");
    boolean sv = false;
    System.out.println(a.checkTicket(h, s, sv));
    System.out.println(b.checkTicket(h, s, sv));
    System.out.println(c.checkTicket(h, s, sv));
    System.out.println(d.checkTicket(h, s, sv));
    */
  }
  
public static void main(String args[]) {
    TopicSeven go = new TopicSeven();
    go.exerciseElevenPointOne();
    go.projectFiveDashSix();
    System.out.println(go.reversedWords("computer science"));
    System.out.println(go.reversedWords("uranus"));
    System.out.println(go.raisedPower(3, 4));
    System.out.println(go.raisedPower(5, -2));
    System.out.println(go.findFactorial(6));
    int[] q = {2, 4, 3, 6, 8, 2, 3};
    int[] r = {8, 2, 4, 6, 2, 4, 6, 4, 2, 7};
    double qAvg, rAvg;
    qAvg = go.averageValues(q);
    rAvg = go.averageValues(r);
    System.out.println("qAvg " + qAvg);
    System.out.println("rAvg " + rAvg);
    go.nutrition();
    go.hanna();
    go.dcl();
    go.pt();
  }  
}