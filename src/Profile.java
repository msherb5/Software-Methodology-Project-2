public class Profile {
    private String fname;
    private String lname;


    public Profile(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String newFName) {
        this.fname = newFName;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String newLName) {
        this.lname = newLName;
    }

    public String toString(){
        return "*"+this.fname + " " + this.lname + "*";
    }


}