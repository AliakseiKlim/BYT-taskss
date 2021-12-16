package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;

	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

    @Test
    public void testGetName() {
        assertEquals("SweBank", SweBank.getName());
        assertEquals("DanskeBank", DanskeBank.getName());
    }

    @Test
    public void testGetCurrency() {
        assertEquals(DKK, DanskeBank.getCurrency());
        assertNotEquals(SEK, DanskeBank.getCurrency());
    }

    @Test
    public void testOpenAccount() throws AccountExistsException {
        assertThrows(AccountExistsException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                DanskeBank.openAccount("Gertrud");
            }
        });
        SweBank.openAccount("123123123");
        assertTrue(SweBank.exist("123123123"));
    }

    @Test
    public void testDeposit() throws AccountDoesNotExistException {
        assertThrows(AccountDoesNotExistException.class,new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                DanskeBank.deposit("123123123", new Money(10000, DKK));
            }
        });

        DanskeBank.deposit("Gertrud", new Money(123456, DKK));
        assertEquals(DanskeBank.getBalance("Gertrud"), 123456,1);
    }

    @Test
    public void testWithdraw() throws AccountDoesNotExistException {
        assertThrows(AccountDoesNotExistException.class,new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                DanskeBank.withdraw("123123123", new Money(10000, DKK));
            }
        });

        DanskeBank.deposit("Gertrud", new Money(123456, DKK));
        DanskeBank.withdraw("Gertrud", new Money(456, DKK));
        assertEquals(DanskeBank.getBalance("Gertrud"), 123000,1);
    }

    @Test
    public void testGetBalance() throws AccountDoesNotExistException {
        assertEquals(0,DanskeBank.getBalance("Gertrud"),0);

        DanskeBank.deposit("Gertrud", new Money(123456, DKK));

        assertEquals(123456,DanskeBank.getBalance("Gertrud"),0);
    }

    @Test
    public void testTransfer() throws AccountDoesNotExistException {
        //zero balances each
        SweBank.deposit("Bob", new Money(123456, SEK));


        System.out.println(SweBank.getBalance("Bob"));
        System.out.println(SweBank.getBalance("Ulrika"));

        SweBank.transfer("Bob","Ulrika", new Money(456, SEK));
        assertEquals(123000,SweBank.getBalance("Bob"),1);
        assertEquals(456,SweBank.getBalance("Ulrika"),1);
    }

    @Test
    public void testTimedPayment() throws AccountDoesNotExistException {
        SweBank.addTimedPayment("Ulrika", "666", 10, 2, new Money(10000, SEK), SweBank, "Bob");
        SweBank.tick();
        SweBank.tick();
        SweBank.tick();
        SweBank.tick();
        SweBank.tick();
        assertEquals(10000, SweBank.getBalance("Bob"),1);

        SweBank.removeTimedPayment("Ulrika", "666");

    }
}
