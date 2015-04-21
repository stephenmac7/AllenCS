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
  
  // 3a.
  public boolean isLevelTrailSegment(int start, int end)
  
  // 3b.
  public boolean isDifficult()
  
}