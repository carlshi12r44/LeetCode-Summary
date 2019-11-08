public class windowSum {
    public int[] winSum(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[] {};

        }

        int[] sum = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            sum[0] += nums[i];
        }
        // new sum = previous sum + new number - previous number;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i + k - 1] - nums[i - 1];
        }


        return sum;
    }
}
