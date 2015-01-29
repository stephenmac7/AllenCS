public class BankAccount {
  
  private double balance;
  
  // This constructs a bank account with a zero balance
  public BankAccount() {
    balance = 0;
  }
  
  public BankAccount(double initialBalance) {
    balance = initialBalance;
  }
  
  // Finish this method to deposit money into the bank account
  void deposit(double amount) {
    balance += amount; // assumes good input, because we cannot return failure (if they give a negative deposit)
  }
  
  // Finish this method to withdraw money from the account
  void withdraw(double amount) {
    balance -= amount; // see deposit
  }
  
  // Finish this method to return the balance of the bank account
  double getBalance() {
    return balance;
  }
}