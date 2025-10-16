package calculator;

import calculator.calculation.StringCalculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = readLine();
        int result = StringCalculator.add(input);
        System.out.println("결과 : " +result);
    }
}
