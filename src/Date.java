public class Date implements Comparable<Date> { 
 private int year; 
 private int month; 
 private int day; 
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
     System.out.println(this.month + "/" + this.day + "/" + this.year);
     
 } //in the format mm/dd/yyyy 
 public boolean isValid() { } 
} 
