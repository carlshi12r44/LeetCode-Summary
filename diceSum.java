package com.yifeng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class diceSum {
    public static void diceSum(int dice, int target) {
        List<Integer> chosen = new ArrayList<>();
        diceSumHelper(dice, target, chosen);
    }

    private static void diceSumHelper(int dice, int targetSum, List<Integer> chosen) {
        // back-tracking
        // base case
        if (dice == 0) {
            // what would be the easier the
            // if there is no dice and the sum of the vector is equal to the
            // targetSum
            if (sumAll(chosen) == targetSum) {
                System.out.println(Arrays.toString(chosen.toArray()));
            }

        } else {
            // recursive case
            for (int i = 1; i <= 6; i++) {
                // choose
                chosen.add(i);
                // explore
                diceSumHelper(dice - 1, targetSum, chosen);
                // un-choose
                chosen.remove(chosen.size() - 1);
            }
        }
    }
    private static int sumAll(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        return sum;
    }
    public static void main(String[] args) {
        diceSum(2, 7);
    }
}
