package com.yifeng;

import java.util.*;

public class clutter_OA_before_and_after {
    public static List<String> beforeAndAfterPuzzles(String[] phrases) {
        if (phrases == null || phrases.length == 0) {
            return new ArrayList<>();
        }
        // [first word, all indices ]
        Map<String, List<Integer>> heads = initHeads(phrases);

        Set<String> finalSet = new HashSet<>();
        int index = 0;

        for (String item : phrases) {
            int lastIndex = item.lastIndexOf(" ");
            String lastWord = lastIndex >= 0 ? item.substring(lastIndex + 1) : item;
            if (heads.containsKey(lastWord)) {
                for (int k : heads.get(lastWord)) {
                    if (k == index) {
                        continue;
                    }
                    finalSet.add(item + phrases[k].substring(lastWord.length()));
                }
            }
            index++;
        }

        List<String> res = new ArrayList<>(finalSet);
        Collections.sort(res);

        return res;
    }

    private static Map<String, List<Integer>> initHeads(String[] p) {
        Map<String, List<Integer>> res = new HashMap<>();

        int index = 0;
        for (String item : p) {
            String[] arr = item.split(" ");
            String head = arr[0];

            // put the first word as key
            if (!res.containsKey(head)) {
                res.put(head, new ArrayList<>());
            }
            // put the index into the map
            res.get(head).add(index);
            index++;
        }

        return res;
    }

    public static void main(String[] args) {
        String[] inputs = {"writing code","code rocks"};
        List<String> res = beforeAndAfterPuzzles(inputs);
    }
}
