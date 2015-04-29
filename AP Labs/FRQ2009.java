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
      while (values[j] == values[i] && values[j] < values.length) {
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
  private int getChargingCost(int startHour, int chargeTime) {
    int cost = 0;
    int i = startHour;
    while (chargeTime > 0) {
      cost += rateTable[i];
      i++;
      if (i > 23) {
        i = 0;
      }
      chargeTime--;
    }
    return cost;
  }
  
  // 3b.
  public int getChargeStartTime(int chargeTime) {
    int cost;
    int best = 0;
    int best_cost = getChargingCost(0, chargeTime);
    for (int i = 1; i < 24; i++) {
      cost = getChargingCost(i, chargeTime);
      if (cost < best_cost) {
        best = i;
        best_cost = cost;
      }
    }
    return best;
  }
  
  // 4a.
  private int getIndexForFit(NumberTile tile) {
    // empty list
    if (board.size() == 0) {
      return 0;
    }
    // insert at head
    if (board.get(0).getLeft() == tile.getRight()) {
      return 0;
    }
    // insert at last
    if (board.get(board.size() - 1).getRight() == tile.getLeft()) {
      return board.size();
    }
    // insert in between two tiles
    for (int i = 1; i < board.size(); i++) {
      if (board.get(i - 1).getRight() == tile.getLeft() && board.get(i).getLeft() == tile.getRight()) {
        return i;
      }
    }
    // failure
    return -1;
  }
  
  // 4b.
  public boolean insertTile(NumberTile tile) {
    int ind;
    for (int i = 0; i < 4; i++) {
      ind = getIndexForFit(tile);
      if (ind != -1) {
        board.add(ind, tile);
        return true;
      }
      tile.rotate();
    }
    return false;
  }
}