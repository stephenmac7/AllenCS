import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class World {
  private List<Company> companies;
  private Map<String, Company> players;
  
  public World() {
  }
  
  public int calculateSales(StockItem stockItem, double price) {
    return stockItem.getAmount();
  }
  
  public void addCompany(Company c) {
    companies.add(c);
  }
  
  public void addPlayer(String name, Company c) {
    players.put(name, c);
  }
}