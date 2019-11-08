import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // since a + b + c = 0, meaning c = - (a + b)
        // if we can get the two sum of the and see if
        // there exist a number that match the opposite
        // two sum

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            // sums, target, start index, res
            twoSum(nums, -nums[i], i + 1, res);
        }


        return res;
    }

    private void twoSum(int[] nums, int target, int start, List<List<Integer>> res) {

        for (int l = start, r = nums.length - 1; l < r; r--) {
            while (l < r && nums[l] + nums[r] < target) {
                l++;
            }

            if (l != r && nums[l] + nums[r] == target) {
                List<Integer> path = new ArrayList<>();
                // convert the target back to normal
                path.add(-target);
                path.add(nums[l]);
                path.add(nums[r]);
                res.add(path);

                // skip duplicates
                while (l < r && nums[r - 1] == nums[r]) {
                    r--;
                }
            }

        }
    }

}
