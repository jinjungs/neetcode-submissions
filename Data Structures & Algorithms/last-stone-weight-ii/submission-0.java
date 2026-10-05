class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        // subset x, sum - x
        // diff = |sum - 2*x|

        // dp[i]: can make a subset sum up to i
        // update res if dp[i] is possible.
        int target = sum/2;
        int maxVal = 0;
        boolean dp[] = new boolean[target + 1];
        dp[0] = true;

        for (int stone: stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = dp[j] || dp[j-stone];
                if (dp[j]) maxVal = Math.max(maxVal, j);
            }
        }

        return sum - 2 * maxVal;
    }
}