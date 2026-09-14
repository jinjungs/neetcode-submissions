class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        // dp[i]: minimum extra characters from 0 ~ i-1
        int[] dp = new int[n+1]; 
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            dp[i+1] = Math.min(dp[i+1], dp[i] + 1);
            for (String word: dictionary) {
                int len = word.length();
                if (i + len > n) continue;
                if (word.equals(s.substring(i, i + len))) {
                    dp[i + len] = Math.min(dp[i + len], dp[i]);
                }
            }
        }

        return dp[n];
    }
}