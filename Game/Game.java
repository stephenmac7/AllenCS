import java.util.List;
import java.util.Arrays;

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
  
  private static void setUp(World world, ScanWrapper sc) {
    int players = sc.promptInt("Number of Players");
    
    for (int i = 1; i <= players; i++) {
      world.addCompany(new Company(sc.promptString("Player " + i + " company name")));
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
    System.out.println("change number of runs, cnr:  change the number of times a process action runs, from 0 for a new process");
    System.out.println("add purchase action, apurce: add a purchase action");
    System.out.println("remove action, rema:         remove an action");
    System.out.println("show, s:                     show company again");
    System.out.println("help, h:                     show this help");
    System.out.println("done, d:                     done");
  }
  
  private static boolean match(String sh, String lo, String arg) {
    return arg.equalsIgnoreCase(sh) || arg.equalsIgnoreCase(lo);
  }
  
  private static void showEquipment(List<Equipment> elist, boolean sellPrice) {
    System.out.println("Equipment:");
    for (Equipment e : elist) {
      double price;
      if (sellPrice) {
        price = e.getSellPrice();
      }
      else {
        price = e.getBuyPrice();
      }
      System.out.println(String.format("- %20s %5f", e.toString(), price));
    }
  }

  private static void showAvailableEquipment(Company c) {
    System.out.print("Available ");
    List<Equipment> elist = Arrays.asList(Equipment.values());
    elist.removeAll(c.getEquipment());
    showEquipment(elist, false);
  }

  private static void dispatch(World world, Company c, String opt, ScanWrapper sc) {
    if (match("setp", "set price", opt)) {
      Material item = sc.promptMaterial("Item");
      System.out.println("Current price: " + c.getPrice(item));
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
      showAvailableEquipment(c);
      Equipment item = sc.promptEquipment("Equipment");
      if (c.buyEquipment(item)) {
        System.out.println("Bought.");
      }
      else {
        System.out.println("You already have that!");
      }
    }
    else if (match("selle", "sell equipment", opt)) {
      showEquipment(c.getEquipment(), true); // show sell price
      Equipment item = sc.promptEquipment("Equipment");
      if (c.sellEquipment(item)) {
        System.out.println("Sold.");
      }
      else {
        System.out.println("You don't own that!");
      }
    }
    else if (match("cnr", "change number of runs", opt)) {
      Process p = sc.promptProcess("Process");
      System.out.println("Current # of runs: " + c.getRuns(p));
      int newNumber = sc.promptInt("New #");
      c.setRuns(p, newNumber);
    }
    else if (match("apurce", "add purchase action", opt)) {
      Material m = sc.promptMaterial("Material");
      int amount = sc.promptInt("Amount");
      Company tar = null;
      while (tar == null) {
        tar = world.dgetCompanyByName(sc.promptString("Company"));
      }
      c.addPurchase(m, amount, tar);
    }
    else if (match("rema", "remove action", opt)) {
      Process p = sc.promptProcess("Process");
      c.setRuns(p, 0);
    }
    else if (match("s", "show", opt)) {
      showCompany(c);
    }
    else {
      showHelp();
    }
  }
}