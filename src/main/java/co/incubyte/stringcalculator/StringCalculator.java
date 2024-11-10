package co.incubyte.stringcalculator;

public class StringCalculator {
	
	private static final String EMPTY_STRING = "";
	private static final String NUMBER_STRING = "\\d+";
	
	public static int add(String numbers) {
		
		int result = -1;
		
		if (numbers != null) {
			String trimmedInput = numbers.trim();
			if (trimmedInput.equals(EMPTY_STRING)) {
				result = 0;
			} else if (trimmedInput.matches(NUMBER_STRING)) {
				result = Integer.valueOf(trimmedInput);
			} else if (trimmedInput.contains(",")) {
				String[] numsArray = trimmedInput.split(",");
				result = 0;
				for (String num : numsArray) {
					result += Integer.valueOf(num);
				}
			}
		}
		
		return result;
	}
}
