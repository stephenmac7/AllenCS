import java.util.Scanner;

public class Game {
  public static int main(String[] args) {
    System.out.println("Welcome to Game! You must outlast your competitors in the hard world of business! Good luck.");
    // Init
    World world = new World();
    Scanner sc = new Scanner(System.in);
    
    // Setup
    setUp(world, sc);
    
    //
  }
  
  private static void setUp(World world, Scanner sc) {
    System.out.print("Number of Players: ");
    int players = sc.nextInt();
    
    for (int i = 0; i < players; i++) {
      System.out.print("Player " + i + " company name: ");
      world.addCompany(new Company(sc.nextLine()));
    }
  }

  private static void showHelp() {
    System.out.println("");
  }
}