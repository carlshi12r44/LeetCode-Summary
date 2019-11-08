package com.yifeng;

import java.util.*;

public class google_sameMultipleResult {
    /*
    * @params: array as input
    * Output a tuple (a,b,c,d) where a * b == c * d
    * 输入：1，2，3，4，5，6输出：2
      解释：2，6，3，4） 2*6 == 3*4
          （1，6，2，3） 1*6 == 2*3
      right now we don't consider repeating numbers

      follow-up repeating numbers

      mind map: two for loops we get all the multiplications
      then we should consider use a hashmap to record the
      multiplication and the occurrence, if the same multiplications
      add 1 to res

    * */
    public static int sameMultipleResult(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (j == i) continue;
                if (!map.containsKey(arr[i] * arr[j])) {
                    map.put(arr[i] * arr[j], 1);
                } else {
                    map.put(arr[i] * arr[j], map.get(arr[i] * arr[j]) + 1);
                    temp.add(new int[] {arr[i], arr[j]});
                }
            }
        }
        System.out.println(map.keySet());
        System.out.println(map.values());

        int res = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > 1) {
                res++;
            }
        }

        return res;

    }

    public static void main(String[] args) {

        // 1 2 3 4
        int[] arr = {1,2,3,4,5,6};
        int res = sameMultipleResult(arr);

        System.out.println(res);
    }
}
