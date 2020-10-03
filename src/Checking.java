public class Checking extends Account { 
    private boolean directDeposit; 

    public boolean getDeposit() {
        return directDeposit;
      }
    
      // Setter
      public void setDeposit(boolean newDeposit) {
        this.directDeposit = newDeposit;
      }

    } 
    