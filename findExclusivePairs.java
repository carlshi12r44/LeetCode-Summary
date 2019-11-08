import java.util.*;

public class findExclusivePairs {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt(i);
//        }
//
//        int[][] pairSet = new int[m][2];
//
//        for (int i = 0; i < m; i++) {
//            pairSet[i][0] = sc.nextInt();
//            pairSet[i][1] = sc.nextInt();
//        }

        int[] a = new int[] {1,3,2,4};
        int m = 2;
        int[][] pairSet =  {{3,2}, {1,4}};

        // find all the permutations for the array a
        List<List<Integer>> candidates = subsets(a, new ArrayList<>());
//        System.out.println(Arrays.toString(candidates.toArray()));
        int ans = candidates.size();
        for (List<Integer> candidate : candidates) {
            for (int i = 0; i < m; i++) {
                if (candidate.contains(pairSet[i][0]) && candidate.contains(pairSet[i][1])) {
                    ans--;
                }
            }
        }

        System.out.println(ans);
    }


    public static List<List<Integer>> subsets(int[] nums, List<Integer> temp) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, res, temp, nums);
        return res;
    }

    private static void dfs(int level, List<List<Integer>> res, List<Integer> temp, int[] nums) {
        if (level == nums.length) {
            return;
        }

        for (int i = level; i < nums.length; i++) {
            temp.add(nums[i]);
            res.add(new ArrayList<>(temp));
            dfs(i + 1, res, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
}