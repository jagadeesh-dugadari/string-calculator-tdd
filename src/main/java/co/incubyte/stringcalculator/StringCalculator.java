package co.incubyte.stringcalculator;

public class StringCalculator {
	
	private static final String EMPTY_STRING = "";
	
	public static int add(String numbers) {
		
		int result = -1;
		
		if (numbers != null) {
			String trimmedInput = numbers.trim();
			if (trimmedInput.equals(EMPTY_STRING)) {
				result = 0;
			} else if (trimmedInput.matches("\\d+")) {
				result = Integer.valueOf(trimmedInput);
			}
		}
		
		return result;
	}
}
