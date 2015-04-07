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
  public int nextTankToFill(int threshold)
  
  // 3b.
  public void moveToLocation(int locIndex)
  
  // 4a.
  private void fillBlock(String str)
  
  // 4b.
  public String encryptMessage(String message)
  
}