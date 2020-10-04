public class AccountDatabase {
    private Account[] accounts;
    private int size;

    public AccountDatabase() {
        this.accounts = new Account[5];
        this.size = 0;
    }

 private int find(Account account) {
     String firstName = account.getProfile().getFname();
     String lastName = account.getProfile().getLname();

     for (int i = 0; i < this.size; i++) {
         String fname = (this.accounts[i].getProfile()).getFname();
         String lname = (this.accounts[i].getProfile()).getLname();
        if (fname.equals(firstName) && lname.equals(lastName) && (account.getClass()).isInstance(this.accounts[i].getClass())){
            return i;
        }
    }
    
    return -1;
  }

    private void grow() {
        Account[] temp = new Account[this.size + 5];
        System.arraycopy(accounts, 0, temp, 0, size);
        this.accounts = temp;
    }

    public boolean add(Account account) {
        if (find(account) != -1) {
            return false;
        }

        if (size == accounts.length) { // check if number of items is = to current size of the bag
            grow();
        }
        accounts[size] = account; // place item at end of the bag
        size++;
        return true;

    } // return false if account exists

    public boolean remove(Account account) {

        int itemIndex = find(account);
        if (itemIndex == -1) {
            return false;
        }
        accounts[itemIndex] = accounts[size - 1]; // replace item removed with item at end of bag
        accounts[size - 1] = null;
        size--;
        return true;
    } // return false if account doesn’t exist

    public boolean deposit(Account account, double amount) {
        if (find(account) == -1) {
            return false;
        }
        account.credit(amount);
        return true;
    } // return 0: withdrawal successful, 1: insufficient funds, -1 account doesn’t
      // exist

    public int withdrawal(Account account, double amount) {
        if (find(account) == -1) {
            return -1;
        }

        if (account.getBalance() < amount) {
            return 1;
        }

        account.debit(amount);
        return 0;
    }

    private void sortByDateOpen() {
    } // sort in ascending order

    private void sortByLastName() {
    } // sort in ascending order

    public void printByDateOpen() {
    }

    public void printByLastName() {
    }

    public void printAccounts() {
    }
}
