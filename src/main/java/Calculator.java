public class Calculator {
    // Class attributes
    int variable1;
    int variable2;
    public Calculator(){
        variable1 = 0;
        variable2 = 0;
    }

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
        while (decimalNumber > 0) {
            quaternary += (decimalNumber % 4);
            decimalNumber /= 4;
        }
        StringBuilder reverseQuaternary = new StringBuilder(quaternary).reverse();
        return Integer.parseInt(reverseQuaternary.toString()); //return the quaternary number as integer
    }

    public int square(int quaternaryNumber) {
        int decimalNumber = toDecimal(quaternaryNumber);
        int squaredNumber = decimalNumber * decimalNumber;
        int resultAsQuaternaryNumber = toQuaternary(squaredNumber);
        return resultAsQuaternaryNumber;
    }
}