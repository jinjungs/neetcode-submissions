class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int coin : coins){
                if (coin > amount - i) break;
                if (dp[i] == -1) continue;
                if (dp[coin + i] == -1) {
                    dp[coin + i] = dp[i] + 1;
                } else {
                    dp[coin + i] = Math.min(dp[coin + i], dp[i] + 1);
                }
            }
        }

        return dp[amount];
    }
}
