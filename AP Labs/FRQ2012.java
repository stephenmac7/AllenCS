class FRQ2012 {
  // 1a.
  public void addClimb(String peakName, int climbTime) {
    climbList.add(new ClimbInfo(peakName, climbTime));
  }
    
  // 1b.
  public void addClimb(String peakName, int climbTime) {
    boolean added = false;
    for (int i = 0; i < climbList.size(); i++) {
      if (peakName.compareTo(climbList.get(i).getName()) >= 0) {
        climbList.add(i, new ClimbInfo(peakName, climbTime));
        added = true;
      }
    }
    if (!added) {
      climbList.add(new ClimbInfo(peakName, climbTime));
    }
  }
    
  // 1c.
  // Answer I: 
  // Answer II:
    
  // 3a.
  public int findHorseSpace(String name) {
    for (int i = 0; i < spaces.length; i++) {
      if (spaces[i] != null && name.equals(spaces[i].getName()))
        return i;
    }
    return -1;
  }
    
  // 3b.
  public void consolidate() {
    int nextPos = 0;
    for (int i = 0; i < spaces.length; i++) {
      if (spaces[i] != null) {
        if (i != nextPos) {
          spaces[nextPos] = spaces[i];
          spaces[i] = null;
        }
        nextPos++;
      }
    }
  }
  
  // 4a.
  public int countWhitePixels() {
    int count = 0;
    for (int row = 0; row < pixelValues.length; row++) {
      for (int col = 0; col < pixelValues[0].length; col++) {
        if (pixelValues[row][col] == WHITE) {
          count++;
        }
      }
    }
    return count;
  }
  
  // 4b.
  public void processImage() {
    for (int row = 0; row < pixelValues.length - 2; row++) {
      for (int col = 0; col < pixelValues[0].length - 2; col++) {
        int nValue = pixelValues[row][col] - pixelValues[row + 2][col + 2];
        if (nValue < BLACK) {
          nValue = BLACK;
        }
        else if (nValue > WHITE) {
          nValue = WHITE;
        }
        pixelValues[row][col] = nValue;
      }
    }
  }
}