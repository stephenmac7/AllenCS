class FRQ2009 {
  
  // 1a.
  public static int[] getCubeTosses(NumberCube cube, int numTosses) {
    int[] tosses = new int[numTosses];
    for (int i = 0; i < numTosses; i++) {
      tosses[i] = cube.toss();
    }
    return tosses;
  }
  
  // 1b.
  public static int getLongestRun(int[] values) {
    int longest_index = -1;
    int longest_amt = 1;
    int i = 0;
    int count, j;

    while(i < values.length - 1) {
      j = i + 1;
      while (values[j] == values[i]) {
        j++;
      }
      count = j - i;
      if (count > longest_amt) {
        longest_index = j;
        longest_amt = count;
      }
      i += count;
    }
    return longest_index;
  }
  
  // 3a.
  private int getChargingCost(int startHour, int chargeTime)
  
  // 3b.
  public int getChargeStartTime(int chargeTime)
  
  // 4a.
  private int getIndexForFit(NumberTile tile)
  
  // 4b.
  public boolean insertTile(NumberTile tile)
  
}