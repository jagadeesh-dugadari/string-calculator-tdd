package co.incubyte.stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	
	private static final String EMPTY_STRING = "";
	private static final String NUMBER_STRING = "\\d+";
	private static final String COMMA_STRING = ",";
	private static final String NEW_LINE_STRING = "\n";
	private static final String COMMA_OR_NEW_LINE_STRING = ",|\n";
	
	
	public static int add(String numbers) {
		
		int result = -1;
		
		if (numbers != null) {
			String trimmedInput = numbers.trim();
			if (trimmedInput.equals(EMPTY_STRING)) {
				result = 0;
			} else if (trimmedInput.matches(NUMBER_STRING)) {
				result = Integer.valueOf(trimmedInput);
			} else if (trimmedInput.startsWith("//")) {
				Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numbers);
				if (m.matches()) {
					String customDelim = m.group(1);
					String nums = m.group(2);
					result = Arrays.stream(nums.split(Pattern.quote(customDelim))).mapToInt(num -> Integer.valueOf(num.trim())).sum();
				}
			} else if (trimmedInput.contains(COMMA_STRING) || trimmedInput.contains(NEW_LINE_STRING)) {
				result = Arrays.stream(trimmedInput.split(COMMA_OR_NEW_LINE_STRING)).mapToInt(num -> Integer.valueOf(num.trim())).sum();
			}
		}
		
		return result;
	}
}
