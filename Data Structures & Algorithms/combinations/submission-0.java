class Solution {
    int n;
    int k;
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        this.res = new ArrayList<>();

        backTrack(1, new ArrayList<>());

        return res;
    }

    public void backTrack(int num, List<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = num; i <= n; i++) {
            path.add(i);
            backTrack(i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}