package co.incubyte.stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	
	private static final String EMPTY_STRING = "";
	private static final String NUMBER_STRING = "\\d+";
	private static final String NEGATIVE_NUMBER_STRING = "-\\d+";
	private static final String COMMA_STRING = ",";
	private static final String NEW_LINE_STRING = "\n";
	private static final String COMMA_OR_NEW_LINE_STRING = ",|\n";
	private static final String DOUBLE_SLASH_STRING = "//";
	private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
	
	
	public static int add(String numbers) {
		
		int result = -1;
		
		if (numbers != null) {
			String trimmedInput = numbers.trim();
			if (trimmedInput.equals(EMPTY_STRING)) {
				result = 0;
			} else if (trimmedInput.matches(NUMBER_STRING)) {
				result = Integer.valueOf(trimmedInput);
			} else if (trimmedInput.startsWith(DOUBLE_SLASH_STRING)) {
				Matcher customDelimiterMatcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(numbers);
				if (customDelimiterMatcher.matches()) {
					String customDelimiter = customDelimiterMatcher.group(1);
					String numsWithCustomDelimiter = customDelimiterMatcher.group(2);
					result = getSumForStringArray(numsWithCustomDelimiter.split(Pattern.quote(customDelimiter)));
				}
			} else if (trimmedInput.contains(COMMA_STRING) || trimmedInput.contains(NEW_LINE_STRING)) {
				result = getSumForStringArray(trimmedInput.split(COMMA_OR_NEW_LINE_STRING));
			} else if (trimmedInput.matches(NEGATIVE_NUMBER_STRING)) {
				throw new RuntimeException("negative numbers not allowed "+trimmedInput);
			}
		}
		
		return result;
	}
	
	public static int getSumForStringArray(String[] arr) {
		return Arrays.stream(arr).mapToInt(num -> Integer.valueOf(num.trim())).sum();
	}
}
