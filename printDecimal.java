package com.yifeng;

public class printDecimal {
    // since we have 0 to 9 in decimal so we need a loop to make the choices
    public static void printDecimal(int digits, String decimal) {
        if (digits == 0) {
            System.out.println(decimal);
        } else {
            for (int i = 0; i <= 9; i++) {
                String prefix = String.valueOf(i);
                printDecimal(digits - 1, decimal + prefix);
            }
        }
    }

    public static void main(String[] args) {
        printDecimal(2, "");
    }
}
