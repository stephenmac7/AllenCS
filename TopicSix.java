import java.util.*;
import java.lang.*;

public class TopicSix {
  
  Scanner scan = new Scanner(System.in);

  void exerciseTenPointFour() {
    System.out.println("3a. Create a new array double the size and copy the values");
    System.out.println("3b. If we're only using a quarter of the size, it doubles the size of the array");
  }

  int search (Object a[], Object value) {
    for (int i = 0; i < a.length; i++){
      if (a[i].equals(value)){
        return i;
      }
    }
    return -1;
  }
  
  int searchInt (int a[], int value) {
    if (a.length > 0 && a[0] < value){
      return -1;
    }
    for (int i = 0; i < a.length; i++){
      if (a[i] == value){
        return i;
      }
    }
    return -1;
  }

  void exerciseTenPointTwo() {
    // 2
    Integer a[] = {1,5,4};
    System.out.println("5 is at " + search(a, 5));

    System.out.println("3. The last three numbers");
    // 4
    int b[] = {4,6,100};
    System.out.println("3 is at " + searchInt(b, 3));
    System.out.println("5. Checks whether the array is sorted");
  }
  
  void exerciseTenPointThree() {
    System.out.println("1. [8,7,6,5,4] -> [4,7,6,5,8] -> [4,5,6,7,8]");
  }

  void selectionSortInt (int a[]) {
    for (int pos = 0; pos < a.length - 1; pos++) {
      int low = pos;
      for (int cur = pos + 1; cur < a.length; cur++) {
        if (a[cur] < a[low])
          low = cur;
      }
      int temp = a[pos];
      a[pos] = a[low];
      a[low] = temp;
    }
  }

  void selectionSortString (String a[]) {
    for (int pos = 0; pos < a.length - 1; pos++) {
      int low = pos;
      for (int cur = pos + 1; cur < a.length; cur++) {
        if (a[cur].compareTo(a[low]) < 0)
          low = cur;
      }
      String temp = a[pos];
      a[pos] = a[low];
      a[low] = temp;
    }
  }

  void newline() {
    System.out.println("");
  }

  void showInts (int a[]) {
    for (int i : a) {
      System.out.print(i + " ");
    }
    newline();
  }

  void projectTenDashOne() {
    int[] gers = new int[10];

    System.out.println("Give me some numbers to sort.");
    for (int i = 0; i < 10; i++) {
      gers[i] = scan.nextInt();
    }
    scan.nextLine();
    System.out.print("You entered:           ");
    showInts(gers);

    selectionSortInt(gers);
    System.out.print("Here they are, sorted: ");
    showInts(gers);
  }
  
  int median(int[] xs) {
    return xs[xs.length / 2];
  }

  void projectEightDashFour() {
    int[] gers = new int[10];
    selectionSortInt(gers);
    
    System.out.println("I need some numbers so I can find the median:");
    for (int i = 0; i < 10; i++) {
      gers[i] = scan.nextInt();
    }
    scan.nextLine();
    
    System.out.println("The median is: " + median(gers));
  }
  
  void alphabetize() {
    String[] to_sort = new String[15];
    System.out.println("Give me yo' strings:");
    for (int i = 0; i < 15; i++) {
      to_sort[i] = scan.nextLine();
    }
    selectionSortString(to_sort);
    for (String s: to_sort) {
      System.out.println(s);
    }
  }
  
  void chooseYourSort() {
    // sort the following array from lowest to highest number any way you'd like
    int[] sortthis = {7, 2, 4, 0, 9, 1, 3, 10, 6, 8, 5};
    // put sorting code below here
    selectionSortInt(sortthis);
    // put sorting code above here
    System.out.print("cYS: ");
    for (int q = 0; q < sortthis.length; q++)
      System.out.print(sortthis[q] + " ");
    System.out.println();
  }
  
  void everydayImShufflin() {
    // Randomly shuffle the contents of array a into array b
    int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] b = new int[9];
    // shuffle below
    // disgustingly slow and dirty... but you'll have to deal with it
    int i = 0;
    while (i < a.length) {
      int newIndex = (int) (Math.random() * a.length); // Generate random # between 0 and 8
      if (b[newIndex] == 0) {
        b[newIndex] = a[i];
        i++;
      }
    }
    // shuffle above
    System.out.print("eIS: ");
    for (int r = 0; r < b.length; r++)
      System.out.print(b[r] + " ");
    System.out.println();
  }
  
  void testMedian() {
    // Tests median code
    int[] gers = {1, 5, 9}; 
    assert median(gers) == 5;
    
    int[] gers2 = {-10, 0, 5, 9};
    assert median(gers2) == 5;
  }
  
public static void main(String args[]) {
    TopicSix go = new TopicSix();
    go.testMedian();
    go.exerciseTenPointFour();
    go.exerciseTenPointTwo();
    go.exerciseTenPointThree();
    go.projectTenDashOne();
    go.projectEightDashFour();
    go.chooseYourSort();
    go.everydayImShufflin();
    go.alphabetize();
  }  
}