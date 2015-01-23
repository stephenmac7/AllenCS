class ParkTickets {
  
  /* An amusement park has several kinds of tickets:    
   * One-Day, One-Park ticket
   * One-Day, Two-Park ticket
   * Weekday Annual Pass (good at both parks, but not on the weekend)
   * Afternoon Annual Pass (good at both parks, but not before noon)
   * Annual Pass (good at both parks any time)
   * 
   * Finish the class as instructed below:    */
  
  private int id; // an ID number for the ticket
  private boolean twoPark; // true if the ticket can get into both parks
  private boolean weekend; // true if the ticket can get in on the weekend
  private boolean beforeNoon; // true if the ticket can get in before noon
  private boolean annual; // true if the ticket is annual
  
  // 1. Write a constructor that will pass the integer parameter to id
  ParkTickets(int id) {
    this.id = id;
  }
  
  // 2. Write void methods to initialize the boolean values twoPark, weekend, and beforeNoon for the five ticket types
  // Here is the one for the One-Day, One-Park ticket
  
  void oneDayOnePark() {
    twoPark = false;
    weekend = true;
    beforeNoon = true;
    annual = false;
  }
  
  // Now, write the methods for the other four ticket types below
  
  void oneDayTwoPark() {
    twoPark = true;
    weekend = true;
    beforeNoon = true;
    annual = false;
  }
  
  void weekdayAnnual() {
    twoPark = true;
    weekend = false;
    beforeNoon = true;
    annual = true;
  }
  
  void afternoonAnnual() {
    twoPark = true;
    weekend = true;
    beforeNoon = false;
    annual = true;
  }
  
  void annual() {
    twoPark = true;
    weekend = true;
    beforeNoon = true;
    annual = true;
  }
  
  /* 3. Finally, we need to check to see if the ticket is good. In the following method, three values will be passed in:
   *    - The hour of entry, as an int from value 7 (for 7 AM) to 23 (for 11 PM)
   *    - The day of the week, as a String with the following values:
   *                       MF for Monday - Friday, or SS for Saturday - Sunday
   *    - Whether this is the second park visited today, a boolean value that is true if this is the 2nd park visit
   * 
   * Finish the method to return whether the ticket is good for the time and day. The method should return "true" if the ticket is valid */
  
  boolean checkTicket(int hour, boolean weekend, boolean secondVisit, boolean usedBefore) {
    if (hour < 12 && !beforeNoon)
      return false;
    else if (weekend && !this.weekend)
      return false;
    else if (secondVisit && !twoPark)
      return false;
    else if (usedBefore && !annual)
      return false;
    else
      return true;
  }
}
  
    
             