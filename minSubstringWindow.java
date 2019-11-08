package com.yifeng;

public class minSubstringWindow {
    public static String minWindow(String s, String t) {
        if (s == null || s.length() == 0) return "";
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        int[] map = new int[256];

        int l = 0, count = tc.length, max = Integer.MAX_VALUE;

        String res = "";

        for (int i = 0; i < tc.length; i++) {
            map[tc[i]]++;
        }


        // template
        for (int r = 0; r < sc.length; r++) {
            map[sc[r]]--;

            if (map[sc[r]] >= 0) {
                count--;
            }

            while (l < r && map[sc[l]] < 0) {
                map[sc[l]]++;
                l++;
            }

            if (count == 0 && max > r - l + 1) {
                max = r - l + 1;
                res = s.substring(l, r + 1);
            }

        }

        return res;
    }

    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";

        String res = minWindow(S, T);


    }
}
