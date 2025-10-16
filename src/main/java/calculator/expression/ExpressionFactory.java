package calculator.expression;

public class ExpressionFactory {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    public static Expression create(String expression) {
        if (hasCustomDelimiter(expression)) {
            return CustomDelimiterExpression.of(expression, CUSTOM_DELIMITER_PREFIX, CUSTOM_DELIMITER_SUFFIX);
        }
        return new BasicExpression(expression);
    }

    private static boolean hasCustomDelimiter(String expression) {
        return expression.startsWith(CUSTOM_DELIMITER_PREFIX);
    }
}
