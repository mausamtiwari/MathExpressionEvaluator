package be.intecbrussel.MathExpressionEvaluation.service;

import be.intecbrussel.MathExpressionEvaluator.service.BasicMathService;
import be.intecbrussel.MathExpressionEvaluator.service.BasicMathServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BasicMathServiceTest {

    private BasicMathService basicMathService;

    @BeforeAll
    public void beforeAll() {
        // TODO instantiate the service
        basicMathService = new BasicMathServiceImpl();
    }

    @Test
    public void testBasicAdditionOfTwoIntegers() {
        int firstNumber = 7;
        int secondNumber = 6;

        int expectedResult = 13;

        double result = basicMathService.add(firstNumber, secondNumber);

        assertEquals(expectedResult, result);

    }

    @Test
    public void testBasicAdditionOfTwoNegativeIntegers() {
        int firstNumber = -4;
        int secondNUmber = -8;

        int expectedResult = -12;

        double result = basicMathService.add(firstNumber, secondNUmber);
        assertEquals(expectedResult, result);
    }


    @ParameterizedTest
    @MethodSource("basicAdditionFactory")
    public void testBasicAdditions(double number1, double number2, double expectedValue) {
        double result = basicMathService.add(number1, number2);
        assertEquals(expectedValue, result);
    }

    public static Stream<Arguments> basicAdditionFactory() {
        return Stream.of(
                Arguments.of(5, 3, 8),
                Arguments.of(50, 3, 53),
                Arguments.of(-5, 3, -2),
                Arguments.of(0, 0, 0),
                Arguments.of(-7, -3, -10),
                Arguments.of(5, -3, 2),
                Arguments.of(5.5, 4.5, 10),
                Arguments.of(2000000000, 2000000000, 4000000000L),
                Arguments.of(-0.00001, 0.00002, 0.00001),
                Arguments.of(0.99999, 0.000001, 0.999991)
        );
    }


    @ParameterizedTest
    @MethodSource("basicSubtractionFactory")
    public void testBasicSubtractions(double number1, double number2, double expectedValue) {
        double result = basicMathService.subtract(number1, number2);
        assertEquals(expectedValue, result);
    }

    public static Stream<Arguments> basicSubtractionFactory() {
        return Stream.of(
                Arguments.of(5, 3, 2),
                Arguments.of(50, 3, 47),
                Arguments.of(-5, 3, -8),
                Arguments.of(0, 0, 0),
                Arguments.of(-7, -3, -4),
                Arguments.of(5, -3, 8),
                Arguments.of(5.5, 4.5, 1),
                Arguments.of(2000000000, 2000000000, 0),
                Arguments.of(-0.00001, 0.00002, -0.00003),
                Arguments.of(0.99999, 0.000001, 0.999989)
        );
    }


    @ParameterizedTest
    @MethodSource("basicMultiplicationFactory")
    public void testBasicMultiplications(double number1, double number2, double expectedValue) {
        double result = basicMathService.multiply(number1, number2);
        assertEquals(expectedValue, result);
    }

    public static Stream<Arguments> basicMultiplicationFactory() {
        return Stream.of(
                Arguments.of(5, 3, 15),
                Arguments.of(50, 3, 150),
                Arguments.of(-5, 3, -15),
                Arguments.of(0, 0, 0),
                Arguments.of(0, 3, 0),
                Arguments.of(3, 0, 0),
                Arguments.of(-7, -3, 21),
                Arguments.of(5, -3, -15),
                Arguments.of(5.5, 4.5, 24.75),
                Arguments.of(2000000000, 2000000000, 4000000000000000000L),
                Arguments.of(-0.00001, 0.00002, -0.0000000002),
                Arguments.of(0.99999, 0.000001, 0.00000099999)
        );
    }


    @ParameterizedTest
    @MethodSource("basicDivisionFactory")
    public void testBasicDivision(double dividend, double divisor, Object expectedResult) {
        if (expectedResult instanceof Double) {
            assertEquals((double) expectedResult, basicMathService.divide(dividend, divisor), 0.0000001);
        } else if (expectedResult instanceof String) {
            assertThrows(ArithmeticException.class,
                    () -> basicMathService.divide(dividend, divisor), (String) expectedResult);
        }

        /* double result = basicMathService.divide(dividend, divisor);
        assertEquals(expectedValue, result);
         */
    }

    public static Stream<Arguments> basicDivisionFactory() {
        return Stream.of(
                Arguments.of(0, 1, 0),
                Arguments.of(2, 1, 2),
                Arguments.of(3, 2, 1.5),
                Arguments.of(3, 0, "Cannot divide by 0"),
                Arguments.of(0, 0, "Cannot divide by 0"),
                Arguments.of(50, 3, 16.6666667),
                Arguments.of(-5, 3, -1.6666667),
                Arguments.of(-7, -3, 2.33333333333),
                Arguments.of(5, -3, -1.66666666667),
                Arguments.of(5.5, 4.5, 1.22222222222)
        );
    }


    @ParameterizedTest
    @MethodSource("basicDivisionExceptionFactory")
    public void testBAsicDivisionException(double number1, double number2, Class <Exception> expectedException) {
        Assertions.assertThrows(expectedException,
                ()-> basicMathService.divide(number1,number2) );
    }

    public static Stream<Arguments> basicDivisionExceptionFactory() {
        return Stream.of(
                Arguments.of(0, 0, ArithmeticException.class),
                Arguments.of(50, 0, ArithmeticException.class),
                Arguments.of(-5, 0, ArithmeticException.class)
        );
    }

    @ParameterizedTest
    @MethodSource("basicModulusFactory")
    public void testBasicModulus(double dividend, double divisor, double expectedResult) {
        double result = basicMathService.modulus(dividend, divisor);
        assertEquals(expectedResult, result);

    }

    public static Stream<Arguments> basicModulusFactory() {
        return Stream.of(
                Arguments.of(1, 5, 1),
                Arguments.of(15.5, 3, 0.5),
                Arguments.of(8, 2.5, 0.5),
                Arguments.of(-2.5, 2.5, 0),
                Arguments.of(-2, 2.5, -2),
                Arguments.of(9, 2.8, 0.6)
        );
    }

    @ParameterizedTest
    @MethodSource("basicModulusExceptionFactory")
    public void testBAsicModulusException(double number1, double number2, Class <Exception> expectedException) {
        Assertions.assertThrows(expectedException,
                ()-> basicMathService.modulus(number1,number2) );
    }

    public static Stream<Arguments> basicModulusExceptionFactory() {
        return Stream.of(
                Arguments.of(0,0,IllegalArgumentException.class),
                Arguments.of(50, 0, IllegalArgumentException.class),
                Arguments.of(-5, 0, IllegalArgumentException.class)
        );
    }


}
