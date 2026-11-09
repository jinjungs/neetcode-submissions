class Solution {
    boolean[] visitedCol;
    boolean[] visitedDiag;
    boolean[] visitedDiag2;
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.visitedCol = new boolean[n];
        this.visitedDiag = new boolean[n * 2 - 1];
        this.visitedDiag2 = new boolean[n * 2 - 1];
        this.res = new ArrayList<>();

        backTrack(n, 0, new ArrayList<>());
        return res;
    }

    private void backTrack(int n, int row, List<Integer> path) {
        if (row == n) {
            // path: [1, 3, 0, 2]
            List<String> ans = new ArrayList<>();
            for (int col : path) {
                String s = "";
                for (int i = 0; i < n; i++) {
                    if (i == col) {
                        s += "Q";
                    } else {
                        s += ".";
                    }
                }
                ans.add(s);
            }

            res.add(ans);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (visitedCol[col] || visitedDiag[row - col + n - 1] || visitedDiag2[row + col]) continue;
            visitedCol[col] = true;
            visitedDiag[row - col + n - 1] = true;
            visitedDiag2[row + col] = true;
            path.add(col);

            backTrack(n, row + 1, path);

            path.remove(path.size() - 1);
            visitedDiag2[row + col] = false;
            visitedDiag[row - col + n - 1] = false;
            visitedCol[col] = false;
        }
    }
}
