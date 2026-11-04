class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;

        backTrack(1, new ArrayList<>());
        return res;    
    }

    private void backTrack(int num, List<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (num > n) return;

        for (int i = num; i <= n; i++) {
            path.add(i);
            backTrack(i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}