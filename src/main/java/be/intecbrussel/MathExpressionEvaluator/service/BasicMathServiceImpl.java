package be.intecbrussel.MathExpressionEvaluator.service;

import java.math.BigDecimal;

public class BasicMathServiceImpl implements BasicMathService {
    @Override
    public double add(double firstNumber, double secondNumber) {
        String firstNumberAsString = String.valueOf(firstNumber);
        String secondNumberAsString = String.valueOf(secondNumber);

        BigDecimal firstDecimal = new BigDecimal(firstNumberAsString);
        BigDecimal secondDecimal = new BigDecimal(secondNumberAsString);

        BigDecimal result = firstDecimal.add(secondDecimal);

        return result.doubleValue();
        /*
        int amountOfNumbersBeforeDecimal1 = String.valueOf((int) firstNumber).length();
        int amountOfNumbersBeforeDecimal2 = String.valueOf((int) secondNumber).length();

        int amountOfDecimals1 = String.valueOf(firstNumber).length()-amountOfNumbersBeforeDecimal1-1;
        int amountOfDecimals2 = String.valueOf(secondNumber).length()-amountOfNumbersBeforeDecimal2-1;

        int mostDecimals = Integer.max(amountOfDecimals1,amountOfDecimals2);

        int theJonathanNumber = 10;
        for(int i=0;i<mostDecimals;i++){
            theJonathanNumber*=10;
        }

        double jonathan1 = firstNumber*theJonathanNumber;
        double jonathan2 = secondNumber*theJonathanNumber;

        double jonathanResult = jonathan1+jonathan2;
        double realResult = jonathanResult/ theJonathanNumber;


        return realResult;*/
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
        String divisorAsString = String.valueOf(divisor);
        String dividendAsString = String.valueOf(dividend);

        BigDecimal divisorDecimal = new BigDecimal(divisorAsString);
        BigDecimal dividendDecimal = new BigDecimal(dividendAsString);



    }
}
