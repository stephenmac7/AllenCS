import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

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
  }

  // Goes through one time cycle
  // Returns whether the company is still alive
  public boolean cycle(int time, World world) {
    // Go through our expenses, try to make their effects happen, and pay for them
    int numberOfEmployees = employees;
    for (Action a : expenses) {
      // If we're going to do this on this turn, and the expense can (and has been) processed, then pay for it.
      if (a.onTurn(time)) {
        if (a.run(this)) {
          System.out.println("Success: " + a.toString());
        }
        else {
          System.out.println("Falure: " + a.toString());
        }
      }
    }
    employees = numberOfEmployees;

    // Go through and sell our products
    for (Entry<Material, Double> e : prices) {
      sellMaterial(world, e.getKey(), e.getValue());
    }
    
    payEmployees();

    return cash > 0;
  }
  
  public void spend(double cash) {
    this.cash -= cash;
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
    List<StockItem> toBuy = new ArrayList<StockItem();
    toBuy.add(order);

    Double price = prices.get(order.getMaterial()); // if null, this isn't on sale anymore
    if (price == null || !useStock(toBuy)) {
      return false;
    }
    
    double total = order.getAmount() * price;
    to.spend(total);
    cash += total;
    to.addStockItem(order);
  }

  // Pays all our employees once
  private void payEmployees() {
    cash -= employees * 100;
  }

  // Use employees
  private boolean useEmployees(int employees) {
    if (employees > this.employees) {
      return false;
    }
    else {
      this.employees -= employees;
    }
  }
}