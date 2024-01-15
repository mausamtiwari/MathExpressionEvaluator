package be.intecbrussel.MathExpressionEvaluator.service;

public interface BasicMathService {
    double add(double firstNumber, double secondNumber);

    double subtract(double firstNumber, double secondNumber);

    double multiply(double firstNumber, double secondNumber);

    double divide(double dividend, double divider);
}
