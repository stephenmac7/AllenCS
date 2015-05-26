import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.lang.StringBuilder;

public enum Process {
  PLANKING("Planking", 10, 1, 
           new ArrayList<Equipment>(),
           Arrays.asList(new StockItem(Material.WOOD, 1)),
           Arrays.asList(new StockItem(Material.PLANK, 3)));

  private String name;
  private double cost; // How much money this will take, excluding employee, material, and equipment costs
  private int work; // How many employees this takes
  private List<Equipment> requires; // What kind of one-time purchase equipment this requires
  private List<StockItem> in; // What are the materials (and amounts) consumed to produce this
  private List<StockItem> out; // What materials (and amounts) are produced

  private Process(String name, double cost, int work, List<Equipment> requires, List<StockItem> in, List<StockItem> out) {
    this.name = name;
    this.cost = cost;
    this.work = work;
    this.requires = requires;
    this.in = in;
    this.out = out;
  }
  
  public String toString() {
    StringBuilder b = new StringBuilder(String.format("Process: %s\nCost: %f\tWork: %f\nRequires:\n", name, cost, work));
    for (Equipment e : requires) {
      b.append("- ");
      b.append(e);
      b.append("\n");
    }
    b.append("In:\n");
    for (StockItem item : in) {
      b.append("- ");
      b.append(item);
      b.append("\n");
    }
    b.append("Out:\n");
    for (StockItem item : out) {
      b.append("- ");
      b.append(item);
      b.append("\n");
    }
    b.append("\n");
    return b.toString();
  }
  
  public String getName() {
    return name;
  }
  
  public double getCost() {
    return cost;
  }

  public int getWork() {
    return work;
  }

  public List<Equipment> getRequires() {
    return requires;
  }

  public List<StockItem> getIn() {
    return in;
  }

  public List<StockItem> getOut() {
    return out;
  }
  
  public static Process fromString(String name) {
    if (name != null) {
      for (Process b : Process.values()) {
        if (name.equalsIgnoreCase(b.name)) {
          return b;
        }
      }
    }
    return null;
  }
}