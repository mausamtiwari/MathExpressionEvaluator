package be.intecbrussel.MathExpressionEvaluator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BasicMathServiceImpl implements BasicMathService {
    @Override
    public double add(double firstNumber, double secondNumber) {

        BigDecimal firstDecimal = convertDoubleToBigDecimal(firstNumber);
        BigDecimal secondDecimal = convertDoubleToBigDecimal(secondNumber);

        BigDecimal result = firstDecimal.add(secondDecimal);

        return result.doubleValue();

    }

    @Override
    public double subtract(double firstNumber, double secondNumber) {

        BigDecimal firstDecimal = convertDoubleToBigDecimal(firstNumber);
        BigDecimal secondDecimal = convertDoubleToBigDecimal(secondNumber);

        BigDecimal result = firstDecimal.subtract(secondDecimal);

        return result.doubleValue();
    }

    @Override
    public double multiply(double firstNumber, double secondNumber) {

        BigDecimal firstDecimal = convertDoubleToBigDecimal(firstNumber);
        BigDecimal secondDecimal = convertDoubleToBigDecimal(secondNumber);

        BigDecimal result = firstDecimal.multiply(secondDecimal);

        return result.doubleValue();
    }

    @Override
    public double divide(double dividend, double divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        BigDecimal divisorDecimal = convertDoubleToBigDecimal(divisor);
        BigDecimal dividendDecimal = convertDoubleToBigDecimal(dividend);

        BigDecimal result = dividendDecimal.divide(divisorDecimal, 10, RoundingMode.HALF_UP);

        return result.doubleValue();
    }

    @Override
    public double modulus(double dividend, double divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException("Cannot perform modulus with divisor equal to zero");
        }

        BigDecimal divisorDecimal = convertDoubleToBigDecimal(divisor);
        BigDecimal dividendDecimal = convertDoubleToBigDecimal(dividend);

        BigDecimal result = dividendDecimal.remainder(divisorDecimal);

        return result.doubleValue();
    }

    private BigDecimal convertDoubleToBigDecimal(double number) {
        String numberAsString = String.valueOf(number);
        return new BigDecimal(numberAsString);
    }
}
