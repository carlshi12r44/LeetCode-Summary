package com.yifeng;

// the dice should be rolled out using recursion

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class diceRoll {
    public static void diceRoll(int dice) {
        // backtracking
        List<Integer> chosen = new ArrayList<>();
        diceRollHelper(dice, chosen);
    }

    private static void diceRollHelper(int dice, List<Integer> chosen) {
        if (dice == 0) {
            // base case so what is the easiest to do in the function?
            // that would be there is no die to roll
            System.out.println(Arrays.toString(chosen.toArray()));
        } else {
            // recursive case
            for (int i = 1; i <= 6; i++) {
                // choose
                chosen.add(i);
                // explore
                diceRollHelper(dice - 1, chosen);
                // unchoose
                chosen.remove(chosen.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        diceRoll(3);
    }
}
