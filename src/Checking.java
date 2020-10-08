public class Checking extends Account {
  private boolean directDeposit;

  public Checking(String fname, String lname) {
    super(fname, lname);
  }

  public Checking(boolean directDeposit, Date openDate, double balance, String lname, String fname) {
    super(fname, lname, balance, openDate);
    this.directDeposit = directDeposit;
  }


  public boolean getDeposit() {
    return directDeposit;
  }

  // Setter
  public void setDeposit(boolean newDeposit) {
    this.directDeposit = newDeposit;
  }

  @Override
  public double monthlyInterest() {
    double currentBalance = getBalance();

    return currentBalance * (0.0005 / 12);
  }

  @Override
  public double monthlyFee() {
    if (this.directDeposit || getBalance() >= 1500) {
      return 0;
    }
    return 25;
  }

  @Override
  public String toString() {
    String directDep;
    if (directDeposit) {
      directDep = "direct deposit account";
    } else {
      directDep = "";
    }
    return ("*" + this.getClass().getName() + "*" + super.toString() + " " + directDep + "*");

  }
}