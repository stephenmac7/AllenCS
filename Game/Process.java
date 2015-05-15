import java.util.List;

public class Process {
  private String name;
  private double cost; // How much money this will take, excluding employee, material, and equipment costs
  private int work; // How many employees this takes
  private List<Eqipment> requires; // What kind of one-time purchase equipment this requires
  private List<StockItem> in; // What are the materials (and amounts) consumed to produce this
  private List<StockItem> out; // What materials (and amounts) are produced

  public class Process(String name, double cost, int work, List<Equipment> requires, List<StockItem> in, List<StockItem> out) {
    this.name = name;
    this.cost = cost;
    this.work = work;
    this.requires = requires;
    this.in = in;
    this.out = out;
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

  public List<Material> getIn() {
    return in;
  }

  public List<Material> getOut() {
    return out;
  }
}