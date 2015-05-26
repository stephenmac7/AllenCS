import java.util.Scanner;

public class ScanWrapper {
  private Scanner sc;
  
  public ScanWrapper() {
    sc = new Scanner(System.in);
    sc.useDelimiter("\n");
  }
  
  // Prompts
  private int promptInt(String prompt) {
    System.out.print(prompt + ": ");
    return sc.nextInt();
  }
  
  private double promptDouble(String prompt) {
    System.out.print(prompt + ": ");
    return sc.nextDouble();
  }
  
  private String promptString(String prompt) {
    System.out.print(prompt + ": ");
    return sc.next();
  }
  
  private Material promptMaterial(String prompt) {
    return Material.fromString(promptString(prompt));
  }
}