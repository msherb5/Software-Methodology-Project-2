public class AccountDatabase { 
 private Account[] accounts; 
 private int size; 

 public AccountDatabase(){
     this.accounts = new Account[5];
     this.size = 0;
 }
 private int find(Account account) {
     String firstName = account.getProfile().getFname();
     String lastName = account.getProfile().getLname();

     for (int i = 0; i < this.size; i++) {
        if ((this.accounts[i].getProfile().getFname()).equals(firstName) && (this.accounts[i].getProfile().getFname()).equals(lastName) && account instanceOf this.accounts[i].getClass()) {
            return i;
        }
    }
    
    return -1;
  } 
 private void grow() {
        Account[] temp = new Account[this.size + 5];
        System.arraycopy(accounts, 0,temp,0,size);
        this.accounts = temp;
  } 
 public boolean add(Account account) { } //return false if account exists 
 public boolean remove(Account account) { } //return false if account doesn’t exist 
 public boolean deposit(Account account, double amount) { } //return 0: withdrawal successful, 1: insufficient funds, -1 account doesn’t exist 
public int withdrawal(Account account, double amount) { } 
private void sortByDateOpen() { } //sort in ascending order 
private void sortByLastName() { } //sort in ascending order 
public void printByDateOpen() { } 
public void printByLastName() { } 
public void printAccounts() { } 
}
