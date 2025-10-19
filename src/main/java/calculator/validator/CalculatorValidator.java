package calculator.validator;

import calculator.model.CalculatorInput;

public class CalculatorValidator {

    public void validateNumbers(CalculatorInput info) {
        String[] tokens = info.numbers().split(info.delimiter());

        for (String token : tokens) {
            token = token.trim();
            if (token.isEmpty()) continue;

            if (!token.matches("-?\\d+")) {
                throw new IllegalArgumentException("숫자가 아닌 값은 입력할 수 없습니다.");
            }

            int num = Integer.parseInt(token);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        }
    }
}
