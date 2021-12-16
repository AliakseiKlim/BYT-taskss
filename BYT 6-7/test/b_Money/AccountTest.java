package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;

	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		SweBank.deposit("Alice", new Money(1000000, SEK));
	}

	@Test
	public void testAddRemoveTimedPayment() {
        testAccount.addTimedPayment("666", 10,2,new Money(5000000, SEK), SweBank, "Alice");
        assertTrue(testAccount.timedPaymentExists("666"));
        testAccount.removeTimedPayment("666");
        assertFalse(testAccount.timedPaymentExists("666"));
	}

	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
        testAccount.addTimedPayment("666", 10,2,new Money(5000000, SEK), SweBank, "Alice");
        testAccount.timedPaymentExists("666");
        testAccount.tick();
        testAccount.tick();
        testAccount.tick();
        Money shouldbe = new Money(6000000, SEK);
        assertEquals(shouldbe.getAmount(),SweBank.getBalance("Alice"),10);
	}

	@Test
	public void testAddWithdraw() {
	    int amount = 5000;
        testAccount.withdraw(new Money(amount, SEK));
        assertEquals(new Money(10000000-amount, SEK).getAmount(), testAccount.getBalance().getAmount(),1);
	}

	@Test
	public void testGetBalance() {
		assertEquals(10000000,testAccount.getBalance().getAmount(),1);
	}
}
