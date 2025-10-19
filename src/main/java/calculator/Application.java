package calculator;

import calculator.calculation.StringCalculator;
import calculator.expression.StringExpressionFactory;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = readLine();
        StringCalculator stringCalculator = new StringCalculator(new StringExpressionFactory());
        int result = stringCalculator.sum(input);
        System.out.println("결과 : " +result);
    }
}
