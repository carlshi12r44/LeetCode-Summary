package com.yifeng;

public class pow {
    public static int power(int base, int exp) {
        // b ^ e
        // base case
        if (exp == 0) {
            return 1;
        } else {
            // recursive case
            // harder case is bigger than 1
            // 3 ^ 7 = 3 ^ 6 * (3 ^ 1)
            return base * power(base, exp - 1);
        }
    }

    public static void main(String[] args) {
        int res = power(6, 1);
        System.out.println(res);
    }
}
