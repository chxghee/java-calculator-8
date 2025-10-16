package calculator.expression;

import java.util.List;

public interface Expression {
    String getExpressionBody();
    List<String> getDelimiters();
}
