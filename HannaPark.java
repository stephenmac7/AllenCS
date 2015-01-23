class HannaPark {
  /* At Hanna Park, visitors can be charged two different rates:
   * before 10:00 AM, cars are charged one dollar per person
   * after 10:00 AM, cars are charged a flat $3 fee
   * You will create a class that will do the following:
   * - Write a constructor to accept two values: a boolean value that is TRUE if it is before 10:00 AM,
   * and an integer for the number of people in the car
   * - Then, write a method named "cost" to return an integer for how much the car is charged for entering the park */
  boolean is_early;
  int people;

  public HannaPark(boolean is_early, int people) {
    this.is_early = is_early;
    this.people = people;
  }
  
  public int cost() {
    if (is_early) {
      return people;
    }
    else {
      return 3;
    }
  }

}