import java.util.Scanner;

public class Game {
  public static void main(String[] args) {
    System.out.println("Welcome to Game! You must outlast your competitors in the hard world of business! Good luck.");
    // Init
    World world = new World();
    Scanner sc = new Scanner(System.in);
    sc.useDelimiter("\n");
    
    // Setup
    setUp(world, sc);
    
    // Main loop
    String opt = "";
    int time = 1;
    while (!opt.equals("q")) {
      for (Company c : world.getCompanies()) {
        showCompany(c);
        String uopt = "";
        while (!match("d", "done", uopt)) {
          dispatch(world, c, uopt);
          uopt = sc.next();
        }
        if (!c.cycle(time, world)) {
          System.out.println("You went bankrupt. Bye bye.");
          world.removeCompany(c);
        }
      }
      System.out.println("Anyone: q to quit or enter to continue.");
      opt = sc.next();
      if (world.getCompanies().size() == 1) {
        break;
      }
      time++;
    }
    
    // Finish up
    Company most = companies.get(0);
    List<Company> companies = world.getCompanies();
    for (int i = 1; i < companies.size(); i++) {
      if (companies.get(i).getCash() > most.getCash()) {
        most = companies.get(i);
      }
    }
    
    // Announce winner
    System.out.println("Winner:");
    showCompany(most);
  }
  
  private static void setUp(World world, Scanner sc) {
    System.out.print("Number of Players: ");
    int players = sc.nextInt();
    
    for (int i = 1; i <= players; i++) {
      System.out.print("Player " + i + " company name: ");
      world.addCompany(new Company(sc.next()));
    }
    
    System.out.println("\n\nAll set up! Here are all the companies:");
    for (Company c : world.getCompanies()) {
      showCompany(c);
    }
  }
  
  private static void showCompany(Company c) {
    System.out.println(c);
    c.showStock();
    c.showActions();
    c.showEquipment();
    System.out.println("\n");
  }

  private static void showHelp() {
    System.out.println("set price, setp:             set price");
    System.out.println("set employees, sete:         set employees");
    System.out.println("buy equipment, buye:         get new equipment");
    System.out.println("sell equipment, selle:       sell equipment for 4/5 of original price");
    System.out.println("add process action, aproce:  add an action which runs a process");
    System.out.println("change number of runs, cnr:  change the number of times a process action runs");
    System.out.println("add purchase action, apurce: add a purchase action");
    System.out.println("remove action, rema:         remove an action");
    System.out.println("help, h:                     show this help");
    System.out.println("done, d:                     done");
  }
  
  private static boolean match(String sh, String lo, String arg) {
    return arg.equalsIgnoreCase(sh) || arg.equalsIgnoreCase(lo);
  }
  
  private static void dispatch(World world, Company c, String opt) {
  }
}