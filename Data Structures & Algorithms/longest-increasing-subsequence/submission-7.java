class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[2001]; // num + 1000
        int res = 0;

        for (int num : nums) {
            for (int i = 0; i < num + 1000; i++) {
                dp[num + 1000] = Math.max(dp[num + 1000], dp[i] + 1);
                res = Math.max(res, dp[num + 1000]);
            }
        }

        return res;
    }
}
