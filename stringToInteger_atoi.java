public class stringToInteger_atoi {
    public int myAtoi(String str) {
        // find the first index that is not white space
        // use horner's rule to change the text to integer
        // use a flag to record the sign
        if (str.length() == 0 || str == null) {
            return 0;
        }

        long res = 0;
        int i = 0, sign = 1, n = str.length();

        // find the first non-white space index
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }

        // if all the str is white space, return 0
        if (i >= n) {
            return 0;
        }

        // for the sign, we need to check if the i is '+' or '-'
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        // now the i has been pointing to the digits
        while (i < n && Character.isDigit(str.charAt(i))) {
            // "365"
            // res = 0 + 3
            // res = 30 + 6
            // res = 360 + 5
            res = res * 10 + (str.charAt(i) - '0');
            // check if the res * sign has exceeded the max/min limits
            if (res * sign < Integer.MIN_VALUE || res * sign > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) res * sign;
    }
}
