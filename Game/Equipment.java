public enum Equipment {
  SAW("Saw", 100),
  AUGER("Auger", 1000),
  FOREST("Forest", 5000);
  
  private String name;
  private double price;
  private Equipment(String name, double price) {
    this.name = name;
    this.price = price;
  }
  
  public String toString() {
    return name;
  }
  
  public double getBuyPrice() {
    return price;
  }
  
  public double getSellPrice() {
    return price * 0.8;
  }
  
  public static Equipment fromString(String name) {
    if (name != null) {
      for (Equipment b : Equipment.values()) {
        if (name.equalsIgnoreCase(b.name)) {
          return b;
        }
      }
    }
    return null;
  }
}