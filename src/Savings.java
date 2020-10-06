public class Savings extends Account { 
    private boolean isLoyal;
    
    public Savings(boolean isLoyal, Date openDate, double balance, String lname, String fname){
      super(fname, lname, balance,openDate);
      this.isLoyal = isLoyal;
    }

    @Override
    public double monthlyInterest(){
      double currentBalance = getBalance();
      if(this.isLoyal){
        return currentBalance * (.0035/12);
      }

      return currentBalance * (0.0025/12);
    }
    @Override
    public double monthlyFee(){
      if(getBalance() >= 300){
        return 0;
      }
      return 5;
    }

    public boolean getLoyal() {
        return isLoyal;
      }
    
      // Setter
      public void setLoyal(boolean newLoyal) {
        this.isLoyal = newLoyal;
      }

      @Override
      public String toString() {
        String specialSavings;
        if(isLoyal){
          specialSavings = "special savings account";
        } else{
          specialSavings = "";
        }
          return ("*" + this.getClass().getName() + "*" + super.toString() + specialSavings + "*" );

      } 
   } 
   