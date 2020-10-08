public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.day = day;
        this.month = month;
    }

    // It returns a value less than 0 if this Date is before the Date argument
    // It returns a value greater than 0 if this Date is after the Date argument
    public int compareTo(Date date) {
        if (this.year > date.year) {
            return 1;
        } else if (this.year < date.year) {
            return -1;
        } else if (this.year == date.year) {
            if (this.month > date.month) {
                return 1;
            } else if (this.month < date.month) {
                return -1;
            } else if (this.month == date.month) {
                if (this.day > date.day) {
                    return 1;
                } else if (this.day < date.day) {
                    return -1;
                } else if (this.day == date.day) {
                    return 0;
                }
            }
        }
        return 0;
    } // return 0, 1, or -1

    @Override
    public String toString() {
        return (this.month + "/" + this.day + "/" + this.year);
    } // in the format mm/dd/yyyy

    public boolean isValid() {
        if (this.month >= 1 && this.month <= 12 && this.day >= 1 && this.day < 32) {

            if ((this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8
                    || this.month == 10 || this.month == 12) && this.day > 30) {
                return false;
            } else if (this.month == 2 && this.day > 29) {
                return false;
            } else if (this.month == 2 && this.day > 28 && !isLeap(this.year)) {
                return false;
            } else {
                return true;
            }

        } else {
            return false;
        }
    }

    public boolean isLeap(int year) {

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }

            } else
                return true;
        } else {
            return false;
        }

    }
}
