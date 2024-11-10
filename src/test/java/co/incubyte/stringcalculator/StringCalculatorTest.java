package co.incubyte.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	
	@Test
	public void shouldReturnZeroForEmptyString() {
		assertEquals(0, StringCalculator.add(""));
	}

}
