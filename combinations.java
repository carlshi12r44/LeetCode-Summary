import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }

        List<Integer> cur = new ArrayList<>();

        dfs(1, n, k, cur, res);

        return res;
    }

    private static void dfs(int start, int n, int k, List<Integer> cur, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int i = start; i <= n; i++) {
            cur.add(i);
            dfs(i + 1, n, k - 1, cur, res);
            // back track the cur element
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;

        List<List<Integer>> res = combine(n, k);

        System.out.println(Arrays.toString(res.toArray()));
    }
}
