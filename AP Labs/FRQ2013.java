class FRQ2013 {
  
  // 1a.
  public DownloadInfo getDownloadInfo(String title) {
    for (DownloadInfo d : downloadList) {
      if (d.getTitle() == title) {
        return d;
      }
    }
    return null;
  }
    
  // 1b.
  public void updateDownloads(List<String> titles) {
    for (String t : titles) {
      DownloadInfo info = getDownloadInfo(t);
      if (info == null) {
        downloadList.add(new DownloadInfo(t));
      }
      else {
        info.incrementTimesDownloaded();
      }
    }
  }

  // 2a.
  public TokenPass(int playerCount) {
    board = new int[10];
    for (int i = 0; i < board.length; i++) {
      board[i] = (int) (Math.random() * 10 + 1);
    }
  }

  // 2b.
  public void distributeCurrentPlayerTokens() {
    int tokens = board[currentPlayer];
    board[currentPlayer] = 0;
    int pos = currentPlayer + 1;
    while (tokens > 0) {
      if (pos >= board.length) {
        pos = 0;
      }
      board[pos] += 1;
      tokens -= 1;
    }
  }
    
  // 4a.
  public SkyView(int numRows, int numCols, double[] scanned) {
    view = new double[numRows][numCols];
    int position = 0;
    for (int row = 0; row < numRows; r++) {
      if (r % 2 == 0) {
        for (int col = 0; col < numCols; col++) {
          view[row][col] = scanned[position];
          position++;
        }
      }
      else {
        for (int c = numCols - 1; c >= 0; c--) {
          view[row][col] = scanned[position];
          position++;
        }
      }
    }
  }
  
  // 4b.
  public double getAverage(int startRow, int endRow, int startCol, int endCol) {
    double sum = 0;
    for (int i = startRow; i <= endRow, i++) {
      for (int j = startCol; j <= endCol; j++) {
        sum += view[i][j];
      }
    }
    return sum / ((endRow - startRow + 1) * (endCol - startCol + 1));
  }

}