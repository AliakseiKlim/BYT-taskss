package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;

	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
        assertEquals(SEK.getName(), "SEK");
        assertEquals(EUR.getName(), "EUR");
	}

	@Test
	public void testGetRate() {
		assertTrue(SEK.getRate()==0.15);
	}

	@Test
	public void testSetRate() {
		SEK.setRate(0.5);
        assertTrue(SEK.getRate()==0.5);
	}

	@Test
	public void testGlobalValue() {
        assertEquals(EUR.universalValue(16700), (int) (16700/1.5), 1);
	}

	@Test
	public void testValueInThisCurrency() {

        int value = (int) (16700/EUR.getRate()*SEK.getRate());
        System.out.println(value);
        System.out.println(SEK.valueInThisCurrency(16700, EUR));
        assertEquals(SEK.valueInThisCurrency(16700, EUR),value,1);
	}

}
