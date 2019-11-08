package com.yifeng;
import java.util.*;
public class convertString {
    /*
    * params: String str
    * if encounter 'a', convert 'a' to 'bb'
    * if encounter 'b', delete 'b'
    * */
    public static String convertString(String s) {
        if (s.equals("") || s.length() == 0) {
            return "";
        }
        // we can convert the string to character array , first and traverse each node to
        // then we can use two counts to counts the occurance of the 'a'
        // if we see b, we delete the b
        // Time O(n), Space O(n)


        char[] sc = s.toCharArray();

        StringBuffer sb = new StringBuffer();

        for(char item : sc) {
            // if encounter the 'b', skip
            if (item == 'b') {
                continue;
            }

            if (item == 'a') {
                sb.append('d');
                sb.append('d');
            } else {
                sb.append(item);
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        String input = "abbccddab";

        String res = convertString(input);

        System.out.print(res);
    }
}
