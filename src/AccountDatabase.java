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
            if (fname.equalsIgnoreCase(firstName) && lname.equalsIgnoreCase(lastName)
                    && ((account.getClass().getName()).equals(this.accounts[i].getClass().getName()))) {
                return i;
            }
        }

        return -1;

    }

    public int getSize() {
        return this.size;
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
        int accountIndex = find(account);
        if (accountIndex == -1) {
            return false;
        }
        accounts[accountIndex].credit(amount);
        return true;
    } // return 0: withdrawal successful, 1: insufficient funds, -1 account doesn’t
      // exist

    public int withdrawal(Account account, double amount) {
        int accountIndex = find(account);
        if (accountIndex == -1) {
            return -1;
        }

        if (amount > this.accounts[accountIndex].getBalance()) {
            return 1;
        }

        this.accounts[accountIndex].debit(amount);
        if (account.getClass().getName().equals(MoneyMarket.class.getName())) {
            ((MoneyMarket) accounts[accountIndex]).addWithdrawals();
        }
        return 0;
    }

    private void sortByDateOpen() {
        int count = accounts.length;
        Account temp;

        for (int i = 0; i < this.size; i++) {
            for (int j = i + 1; j < this.size; j++) {
                if (this.accounts[i].getDateOpen().compareTo(this.accounts[j].getDateOpen()) > 0) {
                    temp = this.accounts[i];
                    this.accounts[i] = this.accounts[j];
                    this.accounts[j] = temp;

                }
            }
        }

    } // sort in ascending order

    private void sortByLastName() {
        Account temp;

        for (int i = 0; i < this.size; i++) {
            for (int j = i + 1; j < this.size; j++) {
                if (this.accounts[i].getProfile().getLname().compareTo(this.accounts[j].getProfile().getLname()) > 0) {
                    temp = this.accounts[i];
                    this.accounts[i] = this.accounts[j];
                    this.accounts[j] = temp;
                }
            }
        }

    } // sort in ascending order

 // sort in ascending order

    public void printByDateOpen() {
        sortByDateOpen();
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.accounts[i].toString());
            System.out.println("-interest: $ " + this.accounts[i].monthlyInterest());
            System.out.println("-fee: $ " + this.accounts[i].monthlyFee());
            System.out.println("-new balance: $ " + (this.accounts[i].getBalance() + this.accounts[i].monthlyInterest()
                    - this.accounts[i].monthlyFee()));
        }
    }

    public void printByLastName() {

        sortByLastName();
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.accounts[i].toString());
            System.out.println("-interest: $ " + this.accounts[i].monthlyInterest());
            System.out.println("-fee: $ " + this.accounts[i].monthlyFee());
            System.out.println("-new balance: $ " + (this.accounts[i].getBalance() + this.accounts[i].monthlyInterest()
                    - this.accounts[i].monthlyFee()));
        }

    }

    public void printAccounts() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.accounts[i].toString());
            
        }

    }
}
