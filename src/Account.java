public abstract class Account {
    private Profile holder;
    private double balance;
    private Date dateOpen;

    public Account(String fname, String lname,double balance, Date dateOpen){
        this.holder = new Profile(fname, lname);
        this.balance = balance;
        this.dateOpen = dateOpen;
    }

    public void debit(double amount) {
        this.balance -= amount;
    } // decrease the balance by amount

    public void credit(double amount) {
        this.balance += amount;
    } // increase the balance by amount

    @Override
    public String toString() {
        return (this.holder.toString() + "* " + this.balance + this.dateOpen.toString());
    }

    public Profile getProfile(){
        return this.holder;
    }

    public double getBalance(){
        return this.balance;
    }

    public Date getDateOpen(){
        return this.dateOpen;
    }

    public abstract double monthlyInterest();

    public abstract double monthlyFee();
}
