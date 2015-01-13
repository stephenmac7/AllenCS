import java.util.List;
import java.util.ArrayList;

class Patron {
  String name;
  List<Book> books = new ArrayList<Book>();
  
  public Patron(String name) {
    this.name = name;
  }
  
  public boolean isBorrowed(String title) {
    for (Book b : books) {
      if (b.getTitle().equals(title)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean returnBook(String title) {
    Book to_remove = null;
    for (Book b : books) {
      if (b.getTitle().equals(title)) {
        to_remove = b;
      }
    }
    if (to_remove == null) {
      return false;
    }
    else {
      return books.remove(to_remove);
    }
  }
  
  public boolean borrowBook(Book b) {
    if (books.size() < 3) {
      return books.add(b);
    }
    else {
      return false;
    }
  }
  
  public String toString() {
    return "Patron: " + name;
  }
  
  public static void main(String[] args) {
    Patron p = new Patron("Mr. Allen");
    // Add books
    assert p.borrowBook(new Book("I win!", "U. Lose"));
    assert p.borrowBook(new Book("Full Moon", "Seymour Buns"));
    assert p.borrowBook(new Book("I like fish", "Ann Chovie"));
    
    // Test checking out too many
    Book b = new Book("You're Kidding", "Shirley U. Jest");
    assert !p.borrowBook(b);
    
    // Check for things that are checked out
    assert p.isBorrowed("I win!");
    
    // Return a book and try adding the new book again
    assert !p.returnBook("Some non-existant title.");
    assert p.returnBook("I win!");
    assert p.borrowBook(b);
    
    System.out.println("All tests passed");
  }
}