public enum Material {
  WOOD("Wood"),
  PLANK("Plank"),
  COAL("Coal");
  
  private String name;
  private Material(String name) {
    this.name = name;
  }
  
  public String toString() {
    return name;
  }
}