import java.util.List;
import java.util.ArrayList;
class FRQ2014 {
  
  // 1a.
  public static String scrambleWord(String word) {
    int index = 0;
    String scrambled = "";
    String here, next;
    while (index < word.length() - 1) {
      here = word.substring(index, index + 1);
      next = word.substring(index + 1, index + 2);
      if (here.equals("A") && !next.equals("A")) {
        scrambled += next + "A";
        index++;
      }
      else {
        scrambled += here;
      }
      index++;
    }
    if (index < word.length()) {
      scrambled += word.substring(index);
    }
    return scrambled;
  }
    
  // 1b.
  public static void scrambleOrRemove(List<String> wordList) {
    int index = 0;
    while (index < wordList.size()) {
      String here = wordList.get(index);
      String scmb = scrambleWord(here);
      if (here.equals(scmb)) {
        wordList.remove(index);
      } else {
        wordList.set(index, scmb);
        index++;
      }
    }
  }
    
  // 3a.
  public SeatingChart(List<Student> studentList, int rows, int cols) {
    seats = new Student[rows][cols];
    int r = 0;
    int c = 0;
    for (Student sdt : studentList) {
      seats[r][c] = sdt;
      r++;
      if (r == rows) {
        r = 0;
        c++;
      }
    }
  }

  // 3b.
  public int removeAbsentStudents(int allowedAbsenses) {
    int evicted = 0;
    for (int row = 0; row < seats.length(); row++) {
      for (int col = 0; col < seats[0].length(); col++) {
        if (seats[row][col] != null && seats[row][col].getAbsenceCount() > allowedAbsences) {
          seats[row][col] = null;
          evicted++;
        }
      }
    }
    return evicted;
  }

  // 4.  
  class Trio implements Menuitem {
    private Sandwitch sandwitch;
    private Salad salad;
    private Drink drink;
    
    public Trio(Sandwitch sandwitch, Salad salad, Drink drink) {
      this.sandwitch = sandwitch;
      this.salad = salad;
      this.drink = drink;
    }
    
    public String getName() {
      return sandwitch.getName() + "/" + salad.getName() + "/" + drink.getName() + " Trio";
    }
    
    public double getPrice() {
      if (sandwitch.getPrice() > salad.getPrice()) {
        if (salad.getPrice() > drink.getPrice()) {
          return salad.getPrice() + sandwitch.getPrice();
        }
        else {
          return drink.getPrice() + sandwitch.getPrice();
        }
      }
      else {
        if (sandwitch.getPrice() > drink.getPrice()) {
          return sandwitch.getPrice() + salad.getPrice();
        }
        else {
          return salad.getPrice() + drink.getPrice();
        }
      }
    }
  }
}