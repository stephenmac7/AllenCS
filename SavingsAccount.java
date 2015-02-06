public class SavingsAccount extends BankAccount {
  // Savings accounts earn interest  
  private double interestRate;
  // And have a minimum balance
  public static final double MINIMUM_BALANCE = 10;
  
  // Write a constructor to set up a savings account with a given interest rate
  SavingsAccount(double rate) {
    super();
    interestRate = rate;
  }
  
  // Write a constructor to set up a savings account with a given balance
  // and interest rate
  SavingsAccount(double initialBalance, double rate) {
    super(initialBalance);
    interestRate = rate;
  }
  
  // Finish this method to add earned interest to the account balance
  void addInterest() {
    deposit(getBalance() + getBalance() * interestRate);
  }
  
  // Override the withdraw method from the superclass
  // So it only withdraws if the result balance is more than
  // the MINIMUM_BALANCE
  void withdraw(double amount) {
    if (getBalance() - amount > MINIMUM_BALANCE) {
      super.withdraw(amount);
    }
  }
}