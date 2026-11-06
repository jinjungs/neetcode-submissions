class Solution {
    char[][] board;
    String word;
    int rows;
    int cols;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.rows = board.length;
        this.cols = board[0].length;
        this.visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (backTrack(r, c, 0)) return true;
            }
        }
        return false;
    }

    int[] dx = new int[] {0, 1, 0, -1};
    int[] dy = new int[] {1, 0, -1, 0};

    private boolean backTrack(int x, int y, int idx) {
        if (idx == word.length()) return true;
        if (x < 0 || x >= rows || y < 0 || y >= cols) return false;
        if (visited[x][y]) return false;
        if (board[x][y] != word.charAt(idx)) return false;

        // visited
        visited[x][y] = true;
        System.out.println(word.charAt(idx));

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (backTrack(nx, ny, idx + 1)) {
                return true;
            }
        }

        visited[x][y] = false;
        return false;
    }
}
