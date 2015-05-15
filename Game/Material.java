public enum Material {
  WOOD("Wood"),
  COAL("Coal");
  
  private String name;
  public Material(String name) {
    this.name = name;
  }
  
  public String toString() {
    return name;
  }
}