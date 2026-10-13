class Solution {
    public int minPathSum(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        // dp[i][j]: shortest path reaches grid[i-1][j-1]
        int[][] dp = new int[ROWS+1][COLS+1];

        int inf = Integer.MAX_VALUE;
        for (int i = 0; i <= ROWS; i++) {
            dp[i][0] = inf;
        }
        for (int j = 0; j <= COLS; j++) {
            dp[0][j] = inf;
        }

        dp[0][1] = 0;
        dp[1][0] = 0;

        for (int i = 1; i <= ROWS; i++) {
            for (int j = 1; j <= COLS; j++) {
                dp[i][j] = grid[i-1][j-1] + Math.min(dp[i][j-1], dp[i-1][j]);
            }
        }

        return dp[ROWS][COLS];
    }
}