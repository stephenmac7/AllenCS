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
  
  public static Material fromString(String name) {
    if (s != null) {
      for (Material b : Material.values()) {
        if (name.equalsIgnoreCase(b.name)) {
          return b;
        }
      }
    }
    return null;
  }
}