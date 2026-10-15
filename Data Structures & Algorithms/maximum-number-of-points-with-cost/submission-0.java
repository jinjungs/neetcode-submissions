class Solution {
    public long maxPoints(int[][] points) {
        int ROWS = points.length;
        int COLS = points[0].length;

        long[] prev = new long[COLS];
        // prev = [0,0,0]
        // 1 2 3
        // j = 0  / leftMax = max(-inf, 0 + 0) = 0
        // curr[0] = 1 + 0 - 0 = 1
        // j = 1 / leftMax = max(0, 0 + 1) = 1
        // curr[1] = 2 + 1 - 1 = 2
        // j = 2 / leftMax = max(1, 0 + 2) = 2
        // curr[2] = 3 + 2 - 2 = 3

        for (int i = 0; i < ROWS; i++) {
            long[] curr = new long[COLS];
            
            // left to right
            long leftMax = Long.MIN_VALUE;
            for (int j = 0; j < COLS; j++) {
                leftMax = Math.max(leftMax, prev[j] + j);
                curr[j] = points[i][j] + leftMax - j;
            }

            // right to left
            long rightMax = Long.MIN_VALUE;
            for (int j = COLS -1; j >= 0; j--) {
                rightMax = Math.max(rightMax, prev[j] - j);
                curr[j] = Math.max(curr[j], points[i][j] + rightMax + j);
            }

            prev = curr;
        }

        long res = 0;
        for (int j = 0; j < COLS; j++) {
            res = Math.max(res, prev[j]);
        }

        return res;
    }
}