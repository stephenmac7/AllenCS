public class ProcessAction extends Action {
  private Process p;
  private int times;

  public ProcessAction(Process p, int times) {
    super("Process: " + p.getName(), 1);
    this.p = p;
    this.times = times;
  }
  
  public void errorMsg(String msg) {
    System.out.println("[" + p + "] ERROR: " + msg);
  }

  public boolean run(Company c) {
    // Check if we have the equipment and materials
    if (!c.hasEquipment(p.getRequires())) {
      errorMsg("Missing eq");
      return false;
    }
    
    // Check if we have enough employees if we do, use 'em
    if (!c.useEmployees(p.getWork())) {
      errorMsg("Missing employees");
      return false;
    }

    // Use our stock
    if (!c.useStock(p.getIn())) {
      errorMsg("Missing stock");
      return false;
    }
    
    // Add our new stock
    c.addStockItems(p.getOut());
    
    // Spend the cash
    c.spend(p.getCost());
    
    // All done!
    return true;
  }
}