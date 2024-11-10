package co.incubyte.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	
	@Test
	public void shouldReturnNegativeNumberForNull() {
		assertEquals(-1, StringCalculator.add(null));
	}
	
	@Test
	public void shouldReturnZeroForEmptyString() {
		assertEquals(0, StringCalculator.add(""));
	}
	
	@Test
	public void shouldReturnZeroForSpaceString() {
		assertEquals(0, StringCalculator.add(" "));
	}
	
	@Test
	public void shouldReturnNegativeNumberForNonNumberString() {
		assertEquals(-1, StringCalculator.add("a"));
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
	
	@Test
	public void shouldReturnSumForCommaMultiNumberString() {
		assertEquals(11, StringCalculator.add("4,7"));
	}
	
	@Test
	public void shouldReturnSumForCommaMultiNumberAndSpaceString() {
		assertEquals(22, StringCalculator.add("4, 7,10,1"));
		assertEquals(22, StringCalculator.add("4,7,10 ,1"));
		assertEquals(22, StringCalculator.add("4,7,10, 1 "));
	}
	
	@Test
	public void shouldReturnSumForCommaNewLineMultiNumberString() {
		assertEquals(6, StringCalculator.add("1\n2,3"));
	}
	
	@Test
	public void shouldReturnSumForCustomDelimiterMultiNumberString() {
		assertEquals(3, StringCalculator.add("//;\n1;2"));
	}
	
	@Test
	public void shouldReturnSumForAnyCustomDelimiterMultiNumberString() {
		assertEquals(3, StringCalculator.add("//~\n1~2"));
	}
	
	@Test
	public void shouldThrowExceptionForNegativeNumberString() {
		try{
			StringCalculator.add("-2");
			fail("Exception expected for negative number");
		} catch (RuntimeException e) {
			// Test pass. Nothing to do
		}
	}
	
	@Test
	public void shouldHaveErroMsgAsExpectedForNegativeNumberString() {
		try{
			StringCalculator.add("-2");
			fail("Exception expected for negative number");
		} catch (RuntimeException e) {
			assertEquals("negative numbers not allowed -2", e.getMessage());
		}
	}
	
	@Test
	public void shouldThrowExceptionForNegativeInMultiNumberString() {
		try{
			StringCalculator.add("-4,1");
			fail("Exception expected for negative number");
		} catch (RuntimeException e) {
			assertEquals("negative numbers not allowed -4", e.getMessage());
		}
	}

}
