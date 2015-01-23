class DCLDining {
  /* Disney Cruise Line utilizes rotational dining, where a family visits a different
   * restaurant every night of their cruise without the need for reservations.
   * This class will assign a restaurant for the first night of the cruise based on a family's room number
   * 
   * Your class should have each of the following:
   * - A constructor that assigns a String for the family last name and an int for the room number
   * - A method named "nameAssign" that returns a String of the restaurant name. There should be three restaurants
   *   (you can name them whatever you'd like), and the correct assignment is based on the modulus of the room number
   * - A void method named "displayRest" that displays (using System.out.println) the family last name, the room number, and the restaurant   
   */
  
  String last_name;
  int room_number;

  public DCLDining(String last_name, int room_number) {
    this.last_name = last_name;
    this.room_number = room_number;
  }
  
  String nameAssign() {
    int n = room_number % 3;
    if (n == 0) {
      return "Restaurant 1";
    } else if (n == 1) {
      return "Restaurant 2";
    } else {
      return "Restaurant 3";
    }
  }
  
  public String toString() {
    return String.format("%s\t\t%d\t%s", last_name, room_number, nameAssign());
  }

  void displayRest() {
    System.out.println(this);
  }

}