import static org.junit.jupiter.api.Assertions.*;

class CheckingTest {

    @org.junit.jupiter.api.Test
    void monthlyInterest() {
        Date date = new Date(1999,12,5);
        Account account = new Checking(true, date, 300, "John", "Smith");
        assertEquals((300 * (.0005/12)), account.monthlyInterest());
    }

    @org.junit.jupiter.api.Test
    void monthlyFee() {
        Date date = new Date(1999,12,5);
        Account noFeeAccount = new Checking(true, date, 1700, "John", "Smith");
        Account directDepositAccount = new Checking(true, date, 500, "Steve", "Smith");
        assertEquals(0, directDepositAccount.monthlyFee());
        assertEquals(0, noFeeAccount.monthlyFee());
    }
}