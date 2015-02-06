import java.util.ArrayList;
import java.util.List;

public class ComputerStudent extends Student {
  private int myPeriod;
  private String myComputer;
  private int myID;
  private List<Double> myGrades = new ArrayList<Double>();
  
  public ComputerStudent(double avg, String name) {
    super(avg, name);
  }

  public void setPeriod(int period) {
    myPeriod = period;
  }
  
  public void setComputer(String computer) {
    myComputer = computer;
  }
  
  public void setID(int id) {
    myID = id;
  }
  
  public void addGrade(double grade) {
    myGrades.add(grade);
  }

  public int getPeriod() {
    return myPeriod;
  }
  
  public String getComputer() {
    return myComputer;
  }
  
  public int getID() {
    return myID;
  }
  
  public double getAverage() {
    double sum = 0;
    
    for (double i : myGrades) {
      sum += i;
    }
    
    return sum / myGrades.size();
  }
}