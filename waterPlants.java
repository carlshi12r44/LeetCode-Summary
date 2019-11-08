package com.yifeng;

public class waterPlants {

    public static int wateringPlants(int[] plants, int m) {
        if (plants.length == 0 || plants == null) {
            return -1;
        }

        int n = plants.length;
        int step = n;
        int C = m; // current water bottle
        int i = n - 1;

        while (i >= 0) {

            int temp = Math.min(plants[i], C);
            plants[i] -= temp;
            C -= temp;

            if (plants[i] == 0) {
                i--;
                continue;
            }

            if (C == 0) {
                C = m;
                step += i + 1;
            }

        }

        return step * 2 - n;
    }

    public static void main(String[] args) {

        int[] plants = {4, 6};
        int C = 3;

        int res = wateringPlants(plants, C);

        System.out.println(res);
    }

}
