package TestSuite;

import Examples.BankAccount;
import Examples.NotEnoughFundsException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Activity2 {

    @Test
    public void notEnoughFunds(){

        //create object and set balance to 10
        BankAccount account = new BankAccount(9);
        //account.withdraw(10);
        //add assertion
        assertThrows(NotEnoughFundsException.class, () -> account.withdraw(10));
    }

    @Test
    public void enoughFunds(){

        //create object and set balance to 100
        BankAccount account = new BankAccount(100);
        //add assertion
        assertDoesNotThrow(() -> account.withdraw(100));
    }
}
