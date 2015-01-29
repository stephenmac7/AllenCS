public class CheckingAccount extends BankAccount {
  
  // The evil bank charges a transaction fee of 50 cents:
  private static final double TRANSACTION_FEE = 0.50;
  
  /*CheckingAccount(double amount) {
    super(amount);
  }*/
  
  // Override the deposit method from BankAccount
  // Don't forget to charge the transaction fee!
  void deposit(double amount) {
    super.deposit(amount - TRANSACTION_FEE);
  }
  
  // Override the withdraw method from BankAccount
  // Don't forget to charge the transaction fee!
  void withdraw(double amount) {
    super.withdraw(amount + TRANSACTION_FEE);
  }
  
  // Finish this method that transfers money from the account to another account
  void transfer(double amount, BankAccount other) {
    withdraw(amount);
    other.deposit(amount);
  }
}