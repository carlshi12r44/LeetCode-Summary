package com.yifeng;

public class checkSubSequence {
    static char[] scString, scWord;
    public static boolean checkSubsequence(String S, String[] words) {
        // brute force
        // for each word in words, so we can check for if the word[0]'s first occurance in
        // S, and for word[1] ... and so on
        if (S == null || S.length() == 0) {
            return false;
        }

        scString = S.toCharArray();
        for (String word : words) {
            if (subsequence(word)) {
                return true;
            }
        }

        return false;
    }

    private static boolean subsequence(String word) {
        scWord = word.toCharArray();
        int i = 0;
        for (char c : scString) {
            if (i < scString.length && c == scWord[i]) {
                i++;
            }
        }

        return (i == scWord.length);
    }

    public static void main(String[] args) {
        String S = "ZUACPP";
        String[] words = {"APP", "APPLE", "ZOO"};
        boolean res = checkSubsequence(S, words);
        System.out.println(res);
    }
}
