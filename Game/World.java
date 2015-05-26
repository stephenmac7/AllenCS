import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class World {
  private List<Company> companies;
  private Map<String, Company> players;
  
  public World() {
    companies = new ArrayList<Company>();
  }
  
  public int calculateSales(StockItem stockItem, double price) {
    return stockItem.getAmount();
  }
  
  public void addCompany(Company c) {
    companies.add(c);
  }
  
  public void removeCompany(Company c) {
    companies.remove(c);
  }
  
  public void addPlayer(String name, Company c) {
    players.put(name, c);
  }
  
  public List<Company> getCompanies() {
    return companies;
  }
}