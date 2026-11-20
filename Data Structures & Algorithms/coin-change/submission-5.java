class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 0; i < amount; i++) {
            if (dp[i] == max) continue;
            for (int coin : coins) {
                if (i <= amount - coin) {
                    dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
                }
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }
}
