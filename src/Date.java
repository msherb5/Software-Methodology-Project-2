public class Date implements Comparable<Date> { 
 private int year; 
 private int month; 
 private int day; 

 public Date(int year, int month, int day){
     this.year = year;
     this.month = month;
     this.day = day;
 }
 public int compareTo(Date date) { 
    if (!(date instanceof Date)){
        return -1;
    }else if (((Date) date).year == this.year && ((Date) date).month == this.month && ((Date)date).day == this.day) {
        return 1;
    }else {
        return 0;
    }
 } //return 0, 1, or -1 
 public String toString() { 
     return (this.month + "/" + this.day + "/" + this.year);
     
 } //in the format mm/dd/yyyy 
 public boolean isValid() {
     if(this.month > 1 && this.month <= 12 && this.day >= 1 && this.day < 32){
         
        if((this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12) && this.day > 30){
            return false;
        } else if(this.month == 2 && this.day > 29){
            return false;
        } else if(this.month == 2 && this.day > 28 && !isLeap(this.year)){
            return false;
        } else {
            return true;
        }

    }else {
        return false;
    }
}
 
public boolean isLeap(int year){
   

        if(year % 4 == 0){
            if( year % 100 == 0){
                if ( year % 400 == 0){
                     return true;
                }else{
                     return false;
                }
                
            } else
                 return true;
        }
        else {
            return false;
        }

        
    }
} 
