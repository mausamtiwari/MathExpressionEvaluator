package be.intecbrussel.MathExpressionEvaluator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BasicMathServiceImpl implements BasicMathService {
    @Override
    public double add(double firstNumber, double secondNumber) {
        String firstNumberAsString = String.valueOf(firstNumber);
        String secondNumberAsString = String.valueOf(secondNumber);

        BigDecimal firstDecimal = new BigDecimal(firstNumberAsString);
        BigDecimal secondDecimal = new BigDecimal(secondNumberAsString);

        BigDecimal result = firstDecimal.add(secondDecimal);

        return result.doubleValue();

    }

    @Override
    public double subtract(double firstNumber, double secondNumber) {
        String firstNumberAsString = String.valueOf(firstNumber);
        String secondNumberAsString = String.valueOf(secondNumber);

        BigDecimal firstDecimal = new BigDecimal(firstNumberAsString);
        BigDecimal secondDecimal = new BigDecimal(secondNumberAsString);

        BigDecimal result = firstDecimal.subtract(secondDecimal);

        return result.doubleValue();
    }

    @Override
    public double multiply(double firstNumber, double secondNumber) {
        String firstNumberAsString = String.valueOf(firstNumber);
        String secondNumberAsString = String.valueOf(secondNumber);

        BigDecimal firstDecimal = new BigDecimal(firstNumberAsString);
        BigDecimal secondDecimal = new BigDecimal(secondNumberAsString);

        BigDecimal result = firstDecimal.multiply(secondDecimal);

        return result.doubleValue();
    }

    @Override
    public double divide(double dividend, double divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        String divisorAsString = String.valueOf(divisor);
        String dividendAsString = String.valueOf(dividend);

        BigDecimal divisorDecimal = new BigDecimal(divisorAsString);
        BigDecimal dividendDecimal = new BigDecimal(dividendAsString);

        BigDecimal result = dividendDecimal.divide(divisorDecimal, 7, RoundingMode.UP);

        return result.doubleValue();
    }

    @Override
    public double modulus(double dividend, double divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException("Cannot perform modulus with divisor equal to zero");
        }

        String divisorAsString = String.valueOf(divisor);
        String dividendAsString = String.valueOf(dividend);

        BigDecimal divisorDecimal = new BigDecimal(divisorAsString);
        BigDecimal dividendDecimal = new BigDecimal(dividendAsString);

        BigDecimal result = dividendDecimal.remainder(divisorDecimal);

        return result.doubleValue();
    }
}
