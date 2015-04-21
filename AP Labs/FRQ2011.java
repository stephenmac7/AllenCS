class FRQ2011 {
  
  // 1a.
  public int limitAmplitude(int limit) {
    int numChanges = 0;
    for (int i = 0; i < this.samples.length; i++) {
      if (this.samples[i] < -limit) {
        this.samples[i] = -limit;
        numChanges++;
      }
      if (this.samples[i] > limit) {
        this.samples[i] = limit;
        numChanges++;
      }
    }
    return numChanges;
  }
  
  // 1b.
  public void trimSilenceFromBeginning() {
    int slienceEnds = 0;
    while (this.samples[silenceEnds] == 0) {
      silenceEnds++;
    }
    int[] newSounds = new int[this.samples.length - silenceEnds];
    for (int i = 0; i < newSounds.length; i++) {
      newSounds[i] = this.samples[silenceEnds + 1];
    }
    this.samples = newSounds;
  }
  
  // 3a.
  public int nextTankToFill(int threshold) {
    int low_index = filler.getCurrentIndex();
    int low = tanks.get(low_index);
    for (int i = 0; i < tanks.size(); i++) {
      if (tanks.get(i) < low) {
        low_index = i;
      }
    }
    return low_index;
  }
  
  // 3b.
  public void moveToLocation(int locIndex) {
    int current = filler.getCurrentIndex();
    if (locIndex >= current) {
      // Go right
      if (!filler.isFacingRight()) {
        filler.changeDirection();
      }
      filler.moveForward(locIndex - current);
    } else {
      // Go left
      if (filler.isFacingRight()) {
        filler.changeDirection();
      }
      filler.moveForward(current - locIndex);
    }
  }
  
  // 4a.
  private void fillBlock(String str) {
    int p = 0;
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        if (p < str.length()) {
          letterBlock[i][j] = str.substring(p, p+1);
          p++;
        }
        else {
          letterBlock[i][j] = "A";
        }
      }
    }
  }
  
  // 4b.
  public String encryptMessage(String message) {
    String m = "";
    int mSize = numRows * numCols;
    while (message.length() > 0) {
      if (mSize > message.length()) {
        mSize = message.length();
      }
      fillBlock(message);
      m += encryptBlock();
      message = message.substring(mSize);
    }
    return m;
  }
  
}