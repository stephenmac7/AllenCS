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
  public String decodeString(ArrayList<StringPart> parts) {
    String s = "";
    for (StringPart p : parts) {
      s += masterString.substring(p.getStart(), p.getStart() + p.getLength());
    }
    return s;
  }
  
  // 2b.
  public ArrayList<StringPart> encodeString(String word) {
    ArrayList<StringPart> parts = new ArrayList<StringPart>();
    
    int pos = 0;
    StringPart sp;
    while (pos < word.length()) {
      sp = findPart(word.substring(pos));
      parts.add(sp);
      pos += sp.getLength();
    }
    
    return parts;
  }
  
  // 4a.
  public class SubstringChecker implements Checker {
    private String substring;
    
    public SubstringChecker(String substring) {
      this.substring = substring;
    }
    
    public accept(String text) {
      return substring.indexOf(text) != -1;
    }
  }
  
  // 4b.
  public class AndChecker implements Checker {
    private Checker a, b;
    
    public AndChecker(Checker a, Checker b) {
      this.a = a;
      this.b = b;
    }
    
    public accept(String text) {
      return a.accept(text) && b.accept(text);
    }
  }
  
  // 4c.
  yummyChecker = AndChecker(NotChecker(aChecker), NotChecker(bChecker));
}
  