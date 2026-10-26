class Solution {
    int rows;
    int cols;
    int[][] grid;
    int res = 0;

    public int getMaximumGold(int[][] grid) {
        // why it is a backtracking?
        // even there's an path that are linked together
        // we can only go for up, down, left, right

        // 0 2 0
        // 3 4 5 
        // 0 6 0

        // mark visited cell with 0
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.grid = grid;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] != 0) {
                    backTrack(r, c, 0);
                }
            }
        }

        return res;
    }

    int[] dr = new int[] {0, 1, 0, -1};
    int[] dc = new int[] {1, 0 , -1, 0};

    public void backTrack(int r, int c, int curr) {
        // visit curr cell
        int gold = grid[r][c];
        grid[r][c] = 0;

        curr += gold;
        res = Math.max(res, curr);

        // loop adjacent cells
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] != 0) {
                backTrack(nr, nc, curr);
            }
        }

        grid[r][c] = gold;
    }
}
