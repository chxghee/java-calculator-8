package calculator.util;

import java.util.Arrays;
import java.util.List;

public class NumberSplitter {

    public static List<Integer> splitAndParseNumbers(String expression, List<String> delimiters) {
        String regex = String.join("|", delimiters);
        String[] numbers = expression.split(regex);
        return parseNumbers(expression, numbers);
    }

    private static List<Integer> parseNumbers(String expression, String[] numbers) {
        try {
            return Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .toList();
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 수식 입력 형식입니다. [입력: " + expression + "]");
        }
    }

}
