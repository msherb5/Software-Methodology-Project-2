public class MoneyMarket extends Account {
  private int withdrawals;

  public MoneyMarket(String fname, String lname) {
    super(fname, lname);
  }

  public MoneyMarket(Date openDate, double balance, String lname, String fname) {

    super(fname, lname, balance, openDate);

  }

  @Override
  public double monthlyInterest() {
    double currentBalance = getBalance();

    return currentBalance * (.0065 / 12);
  }

  @Override
  public double monthlyFee() {
    if (this.withdrawals > 6 || getBalance() < 2500) {
      return 12;
    }
    return 0;
  }

  public int getWithdrawals() {
    return withdrawals;
  }

  // Setter
  public void setWithdrawals(int newWithdrawals) {
    this.withdrawals = newWithdrawals;
  }

  public void addWithdrawals() {
    this.withdrawals++;
  }

  @Override
  public String toString() {
    return ("*" + this.getClass().getName() + "*" + super.toString() + "*" + this.withdrawals + " withdrawals");

  }

}
