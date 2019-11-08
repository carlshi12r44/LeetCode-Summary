package com.yifeng;
// this is intro to the backtracking and recursion
public class printBinary {
    public static void printBinary(int digits, String prefix) {
        // base case
        if (digits == 0) {
            System.out.println(prefix);
        } else {
            // recursive case, multiple digits
            printBinary(digits - 1, prefix + "0");
            printBinary(digits - 1, prefix + "1");
        }
    }


    public static void main(String[] args) {
        printBinary(3, "");
    }
}
