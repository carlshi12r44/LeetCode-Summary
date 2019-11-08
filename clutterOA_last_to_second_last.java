package com.yifeng;

public class clutterOA_last_to_second_last {
    public static String lastToSecondLast(String str) {
        if (str.equals("")) {
            return "";
        }

        int n = str.length();
        char last =  str.charAt(n - 1);
        char secondLast = str.charAt(n - 2);

        return last + " " + secondLast;
    }

    public static void main(String[] args) {
        String res = lastToSecondLast("bat");
        System.out.println(res);
    }
}
