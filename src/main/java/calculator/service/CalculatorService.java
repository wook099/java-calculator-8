package calculator.service;

import calculator.model.CalculatorInput;
import calculator.validator.CalculatorValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {

    private final CalculatorValidator validator = new CalculatorValidator();

    public int calculate(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }
        CalculatorInput info = parseInput(input);
        validator.validateNumbers(info);

        return sumNumbers(info);
    }

    private CalculatorInput parseInput(String input) {
        Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return new CalculatorInput(numbers, delimiter);
        } else {
            return new CalculatorInput(input, ",|:");
        }
    }

    private int sumNumbers(CalculatorInput info) {
        String[] tokens = info.numbers().split(info.delimiter());
        int sum = 0;

        for (String token : tokens) {
            token = token.trim();
            if (token.isEmpty()) continue;
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}
