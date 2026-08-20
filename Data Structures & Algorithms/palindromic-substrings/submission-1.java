class Solution {
    private String s;
    private int n;

    public int countSubstrings(String s) {
        this.s = s;
        this.n = s.length();
        boolean[][] dp = new boolean[n][n];

        int res = 0;
        for (int i = 0; i < n; i++) {
            // odd
            res += expand(i, i, dp);
            // even
            res += expand(i, i+1, dp);
        }

        return res;
    }

    private int expand(int start, int end, boolean[][] dp) {
        int l = start; 
        int r = end;
        int cnt = 0;
        
        while (l >= 0 && r < n) {
            if (s.charAt(l) == s.charAt(r)) {
                if (r - l <= 1 || dp[l+1][r-1]) {
                    dp[l][r] = true;
                    cnt++;
                }
            }
            l--;
            r++;
        }
        
        return cnt;
    }
}
