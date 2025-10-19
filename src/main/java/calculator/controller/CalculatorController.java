package calculator.controller;


import camp.nextstep.edu.missionutils.Console;
import calculator.service.CalculatorService;

public class CalculatorController {

    private final CalculatorService calculatorService = new CalculatorService();

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = calculatorService.calculate(input);

        System.out.println("결과 : " + result);
    }
}
