public class Action {
  String name;
  int rate;

  public Action(String name, int rate) {
    this.name = name;
    this.rate = rate;
  }

  // Tells us whether we need to spend money on this now
  // example (rate = 3, mapped over [1..10]) -> [False, False, True, False, False, True, False, False, True, False]
  public boolean onTurn(int time) {
    return time % rate == 0;
  }

  // Make the changes to the company this expense entails.
  public boolean run(Company c) {
    // This does nothing for a general expense.
    return true;
  }

  public String toString() {
    return name + " every " + rate + " turns.";
  }
}