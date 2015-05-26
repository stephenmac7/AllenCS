import java.lang.StringBuilder;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

public class Company {
  private String name;

  private double cash;
  private int employees;

  private Map<Material, StockItem> stock;
  private Map<Material, Double> prices;
  private List<Action> actions;
  private List<Equipment> equipment;

  public Company(String name) {
    this.name = name;
    cash = 100000; // that's one hundred thousand
    employees = 3;
    
    stock = new HashMap<Material, StockItem>();
    prices = new HashMap<Material, Double>();
    actions = new ArrayList<Action>();
    equipment = new ArrayList<Equipment>();
    
    // Give starter stuff
    addStockItem(new StockItem(Material.WOOD, 50));
    actions.add(new ProcessAction(Process.PLANKING, 1));
    equipment.add(Equipment.SAW);
  }

  // Goes through one time cycle
  // Returns whether the company is still alive
  public boolean cycle(int time, World world) {
    // Go through our expenses, try to make their effects happen, and pay for them
    int numberOfEmployees = employees;
    for (Action a : actions) {
      // If we're going to do this on this turn, and the expense can (and has been) processed, then pay for it.
      if (a.onTurn(time)) {
        if (a.run(this)) {
          System.out.println("Success: " + a.toString());
        }
        else {
          System.out.println("Failure: " + a.toString());
        }
      }
    }
    employees = numberOfEmployees;

    // Go through and sell our products
    for (Entry<Material, Double> e : prices.entrySet()) {
      sellMaterial(world, e.getKey(), e.getValue());
    }
    
    payEmployees();

    return cash > 0;
  }
  
  // Name stuff
  public String getName() {
    return name;
  }

  // Cash get/set/stuff
  public double getCash() {
    return cash;
  }
  
  public void spend(double cash) {
    this.cash -= cash;
  }
  
  // Price get/set/stuff
  public Double getPrice(Material m) {
    return prices.get(m);
  }
  
  public void setPrice(Material m, double price) {
    prices.put(m, price);
  }
  
  public void removePrice(Material m) {
    prices.remove(m);
  }

  // Checks if we have all the equipment in the list
  public boolean hasEquipment(List<Equipment> es) {
    return equipment.containsAll(es);
  }

  // Checks if we have the correct amount of each Material
  public boolean allInStock(List<StockItem> stockItems) {
    for (StockItem needed : stockItems) {
      StockItem inStock = stock.get(needed.getMaterial());
      if (inStock == null || inStock.getAmount() < needed.getAmount()) {
        return false;
      }
    }
    return true;
  }

  // Removes everything in the list from our stock, returns true is successful
  public boolean useStock(List<StockItem> stockItems) {
    if (!allInStock(stockItems)) {
      return false;
    }
    for (StockItem stockItem : stockItems) {
      StockItem inStock = stock.get(stockItem.getMaterial());
      inStock.changeAmount(-stockItem.getAmount());
    }
    return true;
  }

  // Adds stockItem to stock
  public void addStockItem(StockItem stockItem) {
    Material m = stockItem.getMaterial();
    StockItem inStock = stock.get(m);
    if (inStock == null) {
      stock.put(m, stockItem);
    }
    else {
      inStock.changeAmount(stockItem.getAmount());
    }
  }

  // Adds everything in the list to our stock
  public void addStockItems(List<StockItem> stockItems) {
    for (StockItem stockItem : stockItems) {
      addStockItem(stockItem);
    }
  }

  // Sells to consumers in the world
  private void sellMaterial(World w, Material m, double price) {
    StockItem stockItem = stock.get(m);
    int amount = w.calculateSales(stockItem, price);
    if (stockItem.changeAmount(-amount)) {
      cash += price * amount;
    }
    else {
      System.out.println("Something went very wrong. Please check sellMaterial.");
    }
  }
  
  // Sells a material to a company, assuming it's on sale.
  public boolean fillOrder(StockItem order, Company to) {
    // Make a list so we can actually use useStock
    List<StockItem> toBuy = new ArrayList<StockItem>();
    toBuy.add(order);

    Double price = prices.get(order.getMaterial()); // if null, this isn't on sale anymore
    if (price == null || !useStock(toBuy)) {
      return false;
    }
    
    double total = order.getAmount() * price;
    to.spend(total);
    cash += total;
    to.addStockItem(order);
    
    return true;
  }

  // Pays all our employees once
  private void payEmployees() {
    cash -= employees * 100;
  }

  // set/set/use employees
  public int getEmployees() {
    return employees;
  }
  
  public void setEmployees(int employees) {
    this.employees = employees;
  }
  public boolean useEmployees(int employees) {
    if (employees > this.employees) {
      return false;
    }
    else {
      this.employees -= employees;
      return true;
    }
  }
  
  // equipment mod
  public boolean buyEquipment(Equipment e) {
    if (equipment.contains(e)) {
      return false;
    }
    else {
      spend(e.getBuyPrice());
      equipment.add(e);
      return true;
    }
  }
  
  public boolean sellEquipment(Equipment e) {
    if (equipment.contains(e)) {
      cash += e.getSellPrice();
      equipment.remove(e);
      return true;
    }
    else {
      return false;
    }
  }
  
  public List<Equipment> getEquipment() {
    return equipment;
  }
  
  // process action mod
  public int getRuns(Process p) {
    for (Action a : actions) {
      if (a instanceof ProcessAction) {
        ProcessAction b = (ProcessAction) a;
        if (b.getProcess() == p) {
          return b.getTimes();
        }
      }
    }
    return 0;
  }
  
  public void setRuns(Process p, int num) {
    boolean found = false;
    Action remove = null;
    for (Action a : actions) {
      if (a instanceof ProcessAction) {
        ProcessAction b = (ProcessAction) a;
        if (b.getProcess() == p) {
          found = true;
          if (num == 0) {
            remove = b;
          }
          else {
            b.setTimes(num);
          }
          break;
        }
      }
    }
    if (remove != null) {
      actions.remove(remove);
    }
    else if (!found) {
      actions.add(new ProcessAction(p, num));
    }
  }
  
  public void addPurchase(Material m, int amount, Company tar) {
    actions.add(new PurchaseAction(new StockItem(m, amount), tar));
  }
  
  // We always some of these
  public String toString() {
    StringBuilder s = new StringBuilder("Company: ");
    s.append(name);
    s.append("\n_______________________\n");
    s.append("Cash: ");
    s.append(cash);
    s.append("\tEmployees: ");
    s.append(employees);
    return s.toString();
  }

  public void showStock() {
    System.out.println("Stock:\nMaterial\t\tAmount\t\tPrice\n-------------------------------------------------------");
    for (Entry<Material, StockItem> e : stock.entrySet()) {
      System.out.print(e.getKey());
      System.out.print("\t\t");
      System.out.print(e.getValue().getAmount());
      System.out.print("\t\t");
      System.out.println(prices.get(e.getKey()));
    }
  }
  
  public void showActions() {
    System.out.println("Actions:");
    for (int i = 0; i < actions.size(); i++) {
      System.out.println(String.format("%2d %s", i, actions.get(i)));
    }
  }
  
  public void showEquipment() {
    System.out.println("Equipment:");
    for (Equipment e : equipment) {
      System.out.println("- " + e);
    }
  }
}