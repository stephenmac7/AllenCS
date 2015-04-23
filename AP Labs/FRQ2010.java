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
  public boolean isLevelTrailSegment(int start, int end) {
    int min = markers[start];
    int max = markers[start];
    for (int i = start + 1; i <= end; i++) {
      if (markers[i] < min) {
        min = markers[i];
      }
      else if (markers[i] > max) {
        max = markers[i];
      }
    }
    return max - min <= 10;
  }
  
  // 3b.
  public boolean isDifficult() {
    int difficult_parts = 0;
    for (int i = 0; i < markers.length - 1; i++) {
      if (Math.abs(markers[i] - markers[i + 1]) >= 30) {
        difficult_parts++;
      }
    }
    return difficult_parts >= 3;
  }
}