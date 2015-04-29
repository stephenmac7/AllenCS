class FRQ2008 {
  
  // 1a.
  public int getDuration() {
    if (flights.size() == 0) {
      return 0;
    }
    return flights.get(0).getDepartureTime().minutesUntil(flights.get(flights.size() - 1).getArrivalTime());
  }
  
  // 1b.
  public int getShortestLayover() {
    if (flights.size() < 2) {
      return -1;
    }
    int min_layover = Integer.MAX_VALUE;
    for (int i = 0; i < flights.size() - 1; i++) {
      int layover = flights.get(i).getArrivalTime().minutesUntil(flights.get(i + 1).getDepartureTime())
      if (layover < min_layover) {
        min_layover = min_layover;
      }
    }
    return min_layover;
  }
  
  // 2a.
  public String decodeString(ArrayList<StringPart> parts)
  
  // 2b.
  public ArrayList<StringPart> encodeString(String word)
  
  // 4a.
  
  // 4b.
  
  // 4c.

}
  