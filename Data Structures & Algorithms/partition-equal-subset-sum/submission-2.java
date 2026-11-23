class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;

        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = dp.length - 1 - num; i >= 0; i--) {
                dp[i+num] = dp[i+num] || dp[i];
            }
        }

        return dp[target];
    }
}
