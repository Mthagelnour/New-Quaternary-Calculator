public class Calculator {

    public int toDecimal(Integer quaternaryNumber) {
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
}