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
    }
    @Test
    public void decToQuatEdgeCaseNumbers(){
        assertEquals(0, calc.toQuaternary(0));
        assertEquals(1, calc.toQuaternary(1));
        assertEquals(2, calc.toQuaternary(2));
        assertEquals(3, calc.toQuaternary(3));
        assertEquals(10, calc.toQuaternary(4));
    }
    @Test
    public void decToQuatInvalidInputs(){
        assertNull(calc.toQuaternary(-1)); // assumes we want to return null for negative numbers
    }

    // quatToDec() tests
    @Test
    public void quatToDecRandomNumbers() {
        assertEquals(55, calc.toDecimal(313));
        assertEquals(22, calc.toDecimal(112));
        assertEquals(101, calc.toDecimal(1211));
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
}