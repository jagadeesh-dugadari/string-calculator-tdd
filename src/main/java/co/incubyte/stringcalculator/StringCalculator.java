package co.incubyte.stringcalculator;

import java.util.Arrays;

public class StringCalculator {
	
	private static final String EMPTY_STRING = "";
	private static final String NUMBER_STRING = "\\d+";
	private static final String COMMA_STRING = ",";
	
	public static int add(String numbers) {
		
		int result = -1;
		
		if (numbers != null) {
			String trimmedInput = numbers.trim();
			if (trimmedInput.equals(EMPTY_STRING)) {
				result = 0;
			} else if (trimmedInput.matches(NUMBER_STRING)) {
				result = Integer.valueOf(trimmedInput);
			} else if (trimmedInput.contains(COMMA_STRING)) {
				result = Arrays.stream(trimmedInput.split(COMMA_STRING)).mapToInt(Integer::valueOf).sum();
			}
		}
		
		return result;
	}
}
