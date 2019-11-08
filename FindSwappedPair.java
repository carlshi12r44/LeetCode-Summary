package com.yifeng;

/*
* params: int[] A, int[] B
*
* output: boolean isPairFound
* */

public class FindSwappedPair {
    private static int getSum(int[] nums) {
        int m = nums.length;
        int res = 0;
        for (int i = 0; i < m;i++) {
            res += nums[i];
        }
        return res;

    }
    public static boolean swapTwoArrays(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) {
            return false;
        }

        if (A.length == 0 && B.length == 0) {
            return true;
        }


        int m =  A.length, n = B.length, total = 0;
        int ASum = getSum(A);
        int BSum = getSum(B);

        // try each pair
        int newASum = 0, newBSum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newASum = ASum - A[i] + B[j];
                newBSum = BSum - B[j] + A[i];

                if (newASum == newBSum) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] A = {4, 1, 2, 1, 1, 2};
        int[] B = {3, 6, 3, 3};

        int[] A2 = {0, 1};
        int[] B2 = {0};


        System.out.println("Correct Test Case: ");
        boolean result = swapTwoArrays(A, B);

        System.out.println(result);

        System.out.println("Incorrect Test Case: ");
        boolean incorrectResult = swapTwoArrays(A2, B2);

        System.out.println(incorrectResult);
    }
}
