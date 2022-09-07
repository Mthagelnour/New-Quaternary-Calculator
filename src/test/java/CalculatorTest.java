
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

// Tests written with cases retrieved from the following online calculator:
// https://www.convzone.com/decimal-to-quaternary/

class CalculatorTest {
    // decToQuat() tests
    @Test
    void decToQuatRandomNumbers() {
        assertEquals(120, Calculator.toQuaternary(24));
        assertEquals(1121, Calculator.toQuaternary(89));
        assertEquals(30, Calculator.toQuaternary(12));
    }
    @Test
    void decToQuatEdgeCaseNumbers(){
        assertEquals(0, Calculator.toQuaternary(0));
        assertEquals(1, Calculator.toQuaternary(1));
        assertEquals(2, Calculator.toQuaternary(2));
        assertEquals(3, Calculator.toQuaternary(3));
        assertEquals(10, Calculator.toQuaternary(4));
    }
    @Test
    void decToQuatInvalidInputs(){
        assertNull(Calculator.toQuaternary(-1)); // assumes we want to return null for negative numbers
    }

    // quatToDec() tests
    @Test
    void quatToDecRandomNumbers() {
        assertEquals(55, Calculator.toDecimal(313));
        assertEquals(22, Calculator.toDecimal(112));
        assertEquals(101, Calculator.toDecimal(1211));
    }
    @Test
    void quatToDecEdgeCaseNumbers(){
        assertEquals(0, Calculator.toDecimal(0));
        assertEquals(1, Calculator.toDecimal(1));
        assertEquals(2, Calculator.toDecimal(2));
        assertEquals(3, Calculator.toDecimal(3));
        assertEquals(4, Calculator.toDecimal(10));
    }

    // conversion sanity test
    @Test
    void quatDecSanity(){
        var originalInput = 10;
        var temp = Calculator.toQuaternary(originalInput);
        var result = Calculator.toDecimal(temp);
        assertEquals(originalInput, result);
    }
}