package edu.bsu.cs495;

public class Calculator {

    public int toDecimal(int quaternaryNumber) {
        int num = 0;
        int j = 0;
        char[] digitList = String.valueOf(quaternaryNumber).toCharArray();
        for (int i = digitList.length-1; i >= 0; i--){
            num += Integer.parseInt(String.valueOf(digitList[i])) * Math.pow(4, j);
            j++;
        }
        return num;
    }

    public int toQuaternary(int decimalNumber) {
        String quaternary = "";
        boolean isNegative = false;
        if (decimalNumber == 0) {
            return decimalNumber;
        }
        if(decimalNumber < 0){
            isNegative = true;
            decimalNumber *= -1;
        }
        while (decimalNumber > 0) {
            quaternary += (decimalNumber % 4);
            decimalNumber /= 4;
        }

        StringBuilder reverseQuaternary = new StringBuilder(quaternary).reverse();
        int result = Integer.parseInt(reverseQuaternary.toString());
        if(isNegative){
            result *= -1;
        }
        return result; //return the quaternary number as integer
    }

    public int squareRoot(int quaternaryNumber){
        String newDecimal = String.valueOf(toDecimal(quaternaryNumber));
        Double decimalResult = Math.sqrt(Double.parseDouble(newDecimal));
        int quaternaryResult = toQuaternary(decimalResult.intValue());
        return quaternaryResult;
    }

    public int square(int quaternaryNumber) {
        int decimalNumber = toDecimal(quaternaryNumber);
        int squaredNumber = decimalNumber * decimalNumber;
        int resultAsQuaternaryNumber = toQuaternary(squaredNumber);
        return resultAsQuaternaryNumber;
    }
    public int add(int firstQuaternaryNumber, int  SecondQuaternaryNumber) {
        int firstDecimalNumber = toDecimal(firstQuaternaryNumber);
        int SecondDecimalNumber = toDecimal(SecondQuaternaryNumber);
        return toQuaternary(firstDecimalNumber + SecondDecimalNumber);
    }
    public int subtract(int firstQuaternaryNumber, int  SecondQuaternaryNumber) {
        int firstDecimalNumber = toDecimal(firstQuaternaryNumber);
        int SecondDecimalNumber = toDecimal(SecondQuaternaryNumber);
        return toQuaternary(firstDecimalNumber - SecondDecimalNumber);
    }
    public int divide(int firstQuaternaryNumber, int  SecondQuaternaryNumber) {
        int firstDecimalNumber = toDecimal(firstQuaternaryNumber);
        int SecondDecimalNumber = toDecimal(SecondQuaternaryNumber);
        if (SecondDecimalNumber == 0) {
            throw new ArithmeticException("Number Cannot Be Divided by 0");
        } else {
            return toQuaternary(firstDecimalNumber / SecondDecimalNumber);
        }
    }
    public int multiply(int firstQuaternaryNumber, int  SecondQuaternaryNumber) {
        int firstDecimalNumber = toDecimal(firstQuaternaryNumber);
        int SecondDecimalNumber = toDecimal(SecondQuaternaryNumber);
        return toQuaternary(firstDecimalNumber * SecondDecimalNumber);
    }
}