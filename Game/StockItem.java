// StockItem: a material associated with an amount
public class StockItem {
  private Material material;
  private int amount;
  
  public StockItem(Material material, int amount) {
    this.material = material;
    this.amount = amount;
  }
  
  public Material getMaterial() {
    return material;
  }
  
  public int getAmount() {
    return amount;
  }
  
  public boolean changeAmount(int delta) {
    int newAmount = amount + delta;
    if (newAmount >= 0) {
      amount = newAmount;
      return true;
    }
    else {
      return false;
    }
  }
}