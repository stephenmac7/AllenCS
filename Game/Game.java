import java.util.List;

public class Game {
  public static void main(String[] args) {
    System.out.println("Welcome to Game! You must outlast your competitors in the hard world of business! Good luck.");
    // Init
    World world = new World();
    ScanWrapper sc = new ScanWrapper();
    
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
          dispatch(world, c, uopt, sc);
          uopt = sc.promptString("Option");
        }
        if (!c.cycle(time, world)) {
          System.out.println("You went bankrupt. Bye bye.");
          world.removeCompany(c);
        }
      }
      opt = sc.promptString("q to quit or enter to continue");
      if (world.getCompanies().size() == 1) {
        break;
      }
      time++;
    }
    
    // Finish up
    List<Company> companies = world.getCompanies();
    Company most = companies.get(0);
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
    int players = sc.promptInt("Number of Players");
    
    for (int i = 1; i <= players; i++) {
      world.addCompany(new Company(sc.promptString("Player " + i + " company name: ")));
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
    System.out.println("remove price, remp:          removes item from market. Set price to put it back on the market");
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
  
  private static void dispatch(World world, Company c, String opt, Scanner sc) {
    if (match("setp", "set price", opt)) {
      Material item = sc.promptMaterial("Item");
      System.out.print("Current price: " + c.getPrice(item));
      double price = sc.promptDouble("New Price");
      c.setPrice(item, price);
    }
    else if (match("remp", "remove price", opt)) {
      Material item = sc.promptMaterial("Item");
      c.removePrice(item);
    }
    else if (match("sete", "set employees", opt)) {
      System.out.println("Current Number of Employees: " + c.getEmployees());
      c.setEmployees(sc.promptInt("New Number of Employees"));
    }
    else if (match("buye", "buy equipment", opt)) {
      System.out.println("Available Equipment:");
      for (Equipment e : Equipment.values()) {
        System.out.println(String.format("- %20s %5f", e.toString(), e.getBuyPrice()));
      }
    }
    else if (match("selle", "sell equipment", opt)) {
    }
    else if (match("aproce", "add process action", opt)) {
    }
    else if (match("cnr", "change number of runs", opt)) {
    }
    else if (match("apurce", "add purchase action", opt)) {
    }
    else if (match("rema", "remove action", opt)) {
    }
    else {
      showHelp();
    }
  }
}