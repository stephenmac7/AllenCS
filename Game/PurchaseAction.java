public class PurchaseAction extends Action {
  private StockItem stockItem;
  private Company provider;

  public PurchaseExpense(StockItem stockItem, Company provider) {
    super("Purchase: " + stockItem.getMaterial().toString(), 1);
    this.stockItem = stockItem;
    this.provider = provider;
  }

  public boolean run(Company c) {
    return provider.fillOrder(stockItem, c);
  }
}