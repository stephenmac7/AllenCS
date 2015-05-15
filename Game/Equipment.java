public enum Equipment {
  SAW, AUGER, FOREST;
  
  private String name;
  public Equipment(String name) {
    this.name = name;
  }
  
  public String toString() {
    return name;
  }
}