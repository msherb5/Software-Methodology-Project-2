import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @org.junit.jupiter.api.Test
    void isValid() {
        Date test1 = new Date(2020, 8, 2);
        Date test2 = new Date(1999, 2,30);

        assertTrue(test1.isValid());
        assertFalse(test2.isValid());
    }
}