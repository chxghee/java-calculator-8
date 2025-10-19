package calculator.calculation;

import calculator.expression.Expression;
import calculator.expression.ExpressionFactory;
import calculator.util.NumberSplitter;

import java.util.List;

public class StringCalculator {

    private final ExpressionFactory expressionFactory;

    public StringCalculator(ExpressionFactory expressionFactory) {
        this.expressionFactory = expressionFactory;
    }

    public int sum(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }
        Expression expression = expressionFactory.create(inputString);
        return getTerms(expression).stream()
                .reduce(0, Integer::sum);
    }

    private List<Integer> getTerms(Expression expression) {
        List<Integer> terms = NumberSplitter.splitAndParseNumbers(expression.getExpressionBody(), expression.getDelimiters());
        validateTerms(terms);
        return terms;
    }

    private void validateTerms(List<Integer> terms) {
        boolean hasMinus = terms.stream()
                .anyMatch(term -> term < 0);
        if (hasMinus) {
            throw new IllegalArgumentException("음수인 항은 허용되지 않습니다.");
        }
    }
}
