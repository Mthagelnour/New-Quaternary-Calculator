import edu.bsu.cs495.Calculator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// Tests written with cases retrieved from the following online calculator:
// https://www.convzone.com/decimal-to-quaternary/

public class CalculatorTest {


    // decToQuat() tests
    Calculator calc = new Calculator();
    @Test
    public void decToQuatRandomNumbers() {
        assertEquals(120, calc.toQuaternary(24));
        assertEquals(1121, calc.toQuaternary(89));
        assertEquals(30, calc.toQuaternary(12));
        assertEquals(3000321, calc.toQuaternary(12345));
        assertEquals(2121331, calc.toQuaternary(9853));
        assertEquals(-11032320, calc.toQuaternary(-21432));
    }
    @Test
    public void decToQuatEdgeCaseNumbers(){
        assertEquals(0, calc.toQuaternary(0));
        assertEquals(1, calc.toQuaternary(1));
        assertEquals(2, calc.toQuaternary(2));
        assertEquals(3, calc.toQuaternary(3));
        assertEquals(10, calc.toQuaternary(4));
    }

    // quatToDec() tests
    @Test
    public void quatToDecRandomNumbers() {
        assertEquals(55, calc.toDecimal(313));
        assertEquals(22, calc.toDecimal(112));
        assertEquals(101, calc.toDecimal(1211));
        assertEquals(2028, calc.toDecimal(133230));
        assertEquals(4671, calc.toDecimal(1020333));
    }
    @Test
    public void quatToDecEdgeCaseNumbers(){
        assertEquals(0, calc.toDecimal(0));
        assertEquals(1, calc.toDecimal(1));
        assertEquals(2, calc.toDecimal(2));
        assertEquals(3, calc.toDecimal(3));
        assertEquals(4, calc.toDecimal(10));
    }

    // conversion sanity test
    @Test
    public void quatDecSanity(){
        var originalInput = 10;
        var temp = calc.toQuaternary(originalInput);
        var result = calc.toDecimal(temp);
        assertEquals(originalInput, result);
    }

    // add tests
    @Test
    public void addNumbers(){
        assertEquals(2, calc.add(1, 1));
        assertEquals(0, calc.add(0, 0));
        assertEquals(21003, calc.add(1323, 13020));
        assertEquals(133032, calc.add(33213, 33213));
        assertEquals(3113, calc.add(3103, 10));
    }

    // subtract tests
    @Test
    public void subtractNumbers(){
        assertEquals(0, calc.subtract(0, 0));
        assertEquals(1113, calc.subtract(1113, 0));
        assertEquals(0, calc.subtract(33213, 33213));
        assertEquals(-11, calc.subtract(1, 12));
        assertEquals(310121, calc.subtract(312321, 2200));

    }

    // multiply tests
    @Test
    public void multiplyNumbers(){
        assertEquals(0, calc.multiply(0, 112030131));
        assertEquals(12, calc.multiply(2, 3));
        assertEquals(2100, calc.multiply(30, 30));
        assertEquals(211332, calc.multiply(231, 312));
        assertEquals(101301300, calc.multiply(1102, 31320));
    }

    // divide tests
    @Test
    public void divideNumbers(){
        assertEquals(0, calc.divide(10, 11));
        assertEquals(1, calc.divide(10, 10));
        assertEquals(101, calc.divide(310, 3));
        assertEquals(0, calc.divide(310, 3233));
        assertEquals(20, calc.divide(3123, 123));
    }

    @Test
    public void divideByZero(){
        ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> {
            calc.divide(1, 0);
        }, "ArithmeticException was expected");
    }

    @Test
    public void squareNumbers(){
        assertEquals(0, calc.square(0));
        assertEquals(1, calc.square(1));
        assertEquals(2221, calc.square(31));
        assertEquals(10120210, calc.square(2012));
    }

    @Test
    public void sqrtNumbers(){
        assertEquals(0, calc.squareRoot(0));
        assertEquals(1, calc.squareRoot(1));
        assertEquals(31, calc.squareRoot(2221));
    }
}