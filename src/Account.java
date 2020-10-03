public abstract class Account { 
    private Profile holder; 
    private double balance; 
    private Date dateOpen; 
    
    public void debit(double amount) {
        this.balance -= amount;
     } //decrease the balance by amount  
    public void credit(double amount) {
        this.balance += amount;
     } //increase the balance by amount  
    public String toString() {
        System.out.println("Profile: " + holder.getFname() + ", " + holder.getLname() + "Balance: " + balance + "Date: " + date.toString());
     } 
    public abstract double monthlyInterest() { } 
    public abstract double monthlyFee() { } 
} 
