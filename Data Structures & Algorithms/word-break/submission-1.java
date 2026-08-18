class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1]; // dp[i]: until i-1
        dp[0] = true;

        for (int i = 0; i <= n; i++) {
            if (!dp[i]) continue;
            for (String word : wordDict) {
                int size = word.length();
                if (i + size <= n && word.equals(s.substring(i, i + size))) {
                    dp[i + size] = true;
                }
            }
        }

        return dp[n];
    }
}