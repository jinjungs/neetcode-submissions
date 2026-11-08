class Solution {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        this.res = new ArrayList<>();
        backTrack(n, 0, 0, new StringBuilder());
        return res;
    }

    private void backTrack(int n, int left, int right, StringBuilder path) {
        if (left == n && right == n) {
            res.add(path.toString());
            return;
        }

        // left
        if (left < n) {
            path.append('(');
            backTrack(n, left + 1, right, path);
            path.deleteCharAt(path.length() - 1);
        }

        // right
        if (right < left) {
            path.append(')');
            backTrack(n, left, right + 1, path);
            path.deleteCharAt(path.length() - 1);
        }

    }
}
