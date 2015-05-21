public class PurchaseAction extends Action {
  private StockItem stockItem;
  private Company provider;

  public PurchaseAction(StockItem stockItem, Company provider) {
    super("Purchase: " + stockItem.getMaterial().toString(), 1);
    this.stockItem = stockItem;
    this.provider = provider;
  }

  public boolean run(Company c) {
    if (c == null) {
      return false;
    }
    return provider.fillOrder(stockItem, c);
  }
}