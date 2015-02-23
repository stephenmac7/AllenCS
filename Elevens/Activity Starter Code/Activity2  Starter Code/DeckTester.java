/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

 /**
  * The main method in this class checks the Deck operations for consistency.
  * @param args is not used.
  */
 public static void main(String[] args) {
   Deck dt = new Deck(new String[]{"5", "K", "A"}, new String[]{"Clubs", "Spades"}, new int[]{5, 10, 1});
   System.out.println("Initial Deck:");
   System.out.println(dt);
   assert dt.size() == 6;
   line();
   
   System.out.println("Dealing a Card:");
   System.out.println(dt.deal());
   assert dt.size() == 5;
   line();
   
   System.out.println("New Deck:");
   System.out.println(dt);
   line();
   
   System.out.println("An dealt Deck:");
   Deck ed = new Deck(new String[]{"2"}, new String[]{"Clubs"}, new int[]{2});
   ed.deal();
   System.out.println(ed);
   assert ed.isEmpty();
   assert ed.deal() == null;
 }
 
 public static void line() {
   System.out.println("-------------------\n\n\n");
 }
}
