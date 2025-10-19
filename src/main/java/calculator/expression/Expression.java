package calculator.expression;

import java.util.List;

public interface Expression {
    List<String> BASIC_DELIMITERS = List.of(",", ":");
    String getExpressionBody();
    List<String> getDelimiters();
}
