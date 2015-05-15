public class ProcessAction extends Action {
  private Process p;

  public ProcessExpense(Process p) {
    super("Process: " + p.getName(), 1);
    this.p = p;
  }

  public boolean run(Company c) {
    // Check if we have the equipment and materials
    if (!c.hasEquipment(p.getRequires())) {
      return false;
    }
    
    // Check if we have enough employees if we do, use 'em
    if (!c.useEmployees(p.getWork())) {
      return false;
    }

    // Use our stock
    if (c.useStock(p.getIn())) {
      return false;
    }
    
    // Add our new stock
    c.addStockItems(p.getOut());
    
    // Spend the cash
    c.spendCash(p.getCost());
    
    // All done!
    return true;
  }
}