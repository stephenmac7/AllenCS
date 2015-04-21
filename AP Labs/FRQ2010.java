class FRQ2010 {
  
  // 1a.
  public int getTotalBoxes() {
    int sum = 0;
    for (CookieOrder order : orders) {
      sum += order.getNumBoxes();
    }
    return sum;
  }
  
  // 1b.
  public int removeVariety(String cookieVar) {
    int sum = 0;
    for (int i = orders.size() - 1; i >= 0; i--) {
      if (orders.get(i).getVariety().equals(cookieVar)) {
        sum += orders.remove(i).getNumBoxes();
      }
    }
    return sum;
  }
  
  // 2
  class APLine {
    private int a, b, c;
    
    public APLine(int a, int b, int c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }
    
    public double getSlope() {
      return -a / b;
    }
    
    public boolean isOnLine(int x, int y) {
      return (a * x) + (b * y) + c == 0
    }
  }
  
  // 3a.
  public boolean isLevelTrailSegment(int start, int end)
  
  // 3b.
  public boolean isDifficult()
  
}