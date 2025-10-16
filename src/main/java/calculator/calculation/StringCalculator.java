package calculator.calculation;

import calculator.expression.Expression;
import calculator.expression.ExpressionFactory;
import calculator.util.NumberSplitter;

import java.util.List;

public class StringCalculator {

    public static int add(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }
        Expression expression = ExpressionFactory.create(inputString);
        List<Integer> terms = getTerms(expression);
        Adder adder = new Adder(terms);
        return adder.sumTerms();
    }

    private static List<Integer> getTerms(Expression expression) {
        List<Integer> terms = NumberSplitter.splitAndParseNumbers(expression);
        validateTerms(terms);
        return terms;
    }

    public static void validateTerms(List<Integer> terms) {
        boolean hasMinus = terms.stream()
                .anyMatch(term -> term < 0);
        if (hasMinus) {
            throw new IllegalArgumentException("음수인 항은 허용되지 않습니다.");
        }
    }
}
