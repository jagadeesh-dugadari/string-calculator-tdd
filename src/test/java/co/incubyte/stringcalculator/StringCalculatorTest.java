package co.incubyte.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	
	@Test
	public void shouldReturnZeroForEmptyString() {
		assertEquals(0, StringCalculator.add(""));
	}
	
	@Test
	public void shouldReturnZeroForSpaceString() {
		assertEquals(0, StringCalculator.add(" "));
	}
	
	@Test
	public void shouldReturnSameNumberForSingleNumberString() {
		assertEquals(5, StringCalculator.add("5"));
	}
	
	@Test
	public void shouldReturnSameNumberForSingleNumberSpaceString() {
		assertEquals(5, StringCalculator.add("5 "));
		assertEquals(5, StringCalculator.add(" 5"));
		assertEquals(5, StringCalculator.add(" 5 "));
	}

}
