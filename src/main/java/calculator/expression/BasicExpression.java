package calculator.expression;

import java.util.List;

public class BasicExpression implements Expression {

    private static final List<String> BASIC_DELIMITERS = List.of(",", ":");
    private final String expressionBody;

    public BasicExpression(String expression) {
        this.expressionBody = expression;
    }

    @Override
    public String getExpressionBody() {
        return this.expressionBody;
    }

    @Override
    public List<String> getDelimiters() {
        return BASIC_DELIMITERS;
    }
}
