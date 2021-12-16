package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;

	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetAmount() {
        assertEquals(10000,SEK100.getAmount(),0.1);
        assertEquals(0,SEK0.getAmount(),0.1);
        assertEquals(2000,EUR20.getAmount(),0.1);
	}

	@Test
	public void testGetCurrency() {
        assertEquals(EUR, EUR10.getCurrency());
        assertEquals(SEK, SEK100.getCurrency());
        assertEquals(SEK, SEKn100.getCurrency());
	}

	@Test
	public void testToString() {
        assertEquals("10.0 EUR",EUR10.toString() );
        assertEquals("100.0 SEK",SEK100.toString());
	}

	@Test
	public void testGlobalValue() {
	    //manually converting to universal value
        int value = (int) (EUR20.getAmount()/EUR20.getCurrency().getRate());
        assertEquals(value,EUR20.universalValue(), 0);
	}

	@Test
	public void testEqualsMoney() {
		assertEquals(EUR10, EUR10);
		assertEquals(SEK0, SEK0);
		assertNotEquals(EUR10, EUR20);
	}

	@Test
	public void testAdd() {
        int value1 = EUR20.add(EUR10).universalValue();
        int value2 = EUR10.add(EUR20).universalValue();
        assertEquals(value1,value2,1);
	}

	@Test
	public void testSub() {
        int value1 = EUR20.sub(EUR10).universalValue();
        assertEquals(value1,new Money(1000, EUR).universalValue(),1);
	}

	@Test
	public void testIsZero() {
        assertTrue(SEK0.isZero());
	}

	@Test
	public void testNegate() {
		assertTrue(SEKn100.equals(SEK100.negate()));
	}

	@Test
	public void testCompareTo() {
		assertTrue(SEK100.compareTo(SEK200)==-1);
	}
}
