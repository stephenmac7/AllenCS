import java.util.Scanner;

public class ScanWrapper {
  private Scanner sc;
  
  public ScanWrapper() {
    sc = new Scanner(System.in);
    sc.useDelimiter("\n");
  }
  
  // Prompts
  public int promptInt(String prompt) {
    System.out.print(prompt + ": ");
    return sc.nextInt();
  }
  
  public double promptDouble(String prompt) {
    System.out.print(prompt + ": ");
    return sc.nextDouble();
  }
  
  public String promptString(String prompt) {
    System.out.print(prompt + ": ");
    return sc.next();
  }
  
  public Material promptMaterial(String prompt) {
    return Material.fromString(promptString(prompt));
  }
  
  public Equipment promptEquipment(String prompt) {
    return Equipment.fromString(promptString(prompt));
  }
  
  public Process promptProcess(String prompt) {
    return Process.fromString(promptString(prompt));
  }
}