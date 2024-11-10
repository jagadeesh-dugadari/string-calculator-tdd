package co.incubyte.stringcalculator;

public class StringCalculator {
	
	private static final String EMPTY_STRING = "";
	
	public static int add(String numbers) {
		
		int result = -1;
		
		if (numbers.trim().equals(EMPTY_STRING)) {
			result = 0;
		}
		
		return result;
	}
}
