package calculator.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CustomDelimiterExpression implements Expression {

    private final String expressionBody;
    private final String customDelimiter;

    private CustomDelimiterExpression(String expressionBody, String customDelimiter) {
        this.expressionBody = expressionBody;
        this.customDelimiter = customDelimiter;
    }

    public static CustomDelimiterExpression of(String inputString, String prefix, String suffix) {
        int delimiterEndIndex = inputString.indexOf(suffix);

        if (delimiterEndIndex < prefix.length()) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 입력 형식입니다.");
        }

        String customDelimiter = inputString.substring(prefix.length(), delimiterEndIndex);
        String expressionBody = inputString.substring(delimiterEndIndex + suffix.length());

        return new CustomDelimiterExpression(expressionBody, customDelimiter);
    }

    @Override
    public String getExpressionBody() {
        return this.expressionBody;
    }

    @Override
    public List<String> getDelimiters() {
        ArrayList<String> delimiters = new ArrayList<>(BASIC_DELIMITERS);
        delimiters.add(Pattern.quote(this.customDelimiter));
        return delimiters;
    }
}
