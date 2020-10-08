import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyMarketTest {

    @Test
    void monthlyInterest() {
        Date date = new Date(2020, 8,2);
        Account account = new MoneyMarket(date, 500.00, "Dover", "Ben");

        assertEquals((500 * ((.0065) / 12)), account.monthlyInterest());

    }

    @Test
    void monthlyFee() {
        Date date = new Date(2020, 8,2);
        Account less2500 = new MoneyMarket(date, 500.00, "Dover", "Ben");
        Account greater2500 = new MoneyMarket(date, 3000.00, "Mama", "Joe");
        Account withdrawals = new MoneyMarket(date, 500.00, "Draw", "With");

        assertEquals(12, less2500.monthlyFee());
        assertEquals(0,greater2500.monthlyFee());

        AccountDatabase data = new AccountDatabase();
        data.add(withdrawals);


<<<<<<< HEAD
        for(int numWithdraw = 0; numWithdraw < 7; numWithdraw++){
=======
        for(int numWithdraw = 0; numWithdraw < 9; numWithdraw++){
>>>>>>> a659f958e277e50fe1d83245c3ad045dd58cd5b5
            data.withdrawal(withdrawals, 1);

        }
        assertEquals(12, withdrawals.monthlyFee());

    }
}