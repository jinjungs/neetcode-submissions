class Solution {
    int[][][] memo;

    public int findMaxForm(String[] strs, int m, int n) {
        memo = new int[strs.length][m+1][n+1];

        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return dfs(strs, 0, 0, 0, m, n);
    }

    public int dfs(String[] strs, int zeros, int ones, int idx, int m, int n) {
        if (idx == strs.length) {
            return 0;
        }

        if (memo[idx][zeros][ones] != -1) {
            return memo[idx][zeros][ones];
        }

        // count zeros and ones
        int z = 0;
        int o = 0;
        String str = strs[idx];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                z++;
            } else {
                o++;
            }
        }

        if (zeros >= m && ones >= n) {
            return 0;
        }

        // skip
        int skip = dfs(strs, zeros, ones, idx + 1, m, n);

        // visit
        int take = 0;

        if (z + zeros <= m && o + ones <= n) {
            take = 1 + dfs(strs, zeros + z, ones + o, idx + 1, m, n);
        }

        int res = Math.max(skip, take);
        memo[idx][zeros][ones] = res;
        return res;
    }
}