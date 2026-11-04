class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] candidates;
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;

        backTrack(0, 0, new ArrayList<>());
        return res;
    }

    private void backTrack(int idx, int curr, List<Integer> path) {
        if (curr == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (curr + candidates[i] > target) break;
            if (i > idx && candidates[i-1] == candidates[i]) continue;
            
            path.add(candidates[i]);
            backTrack(i + 1, curr + candidates[i], path);
            path.remove(path.size() - 1);
        }
    }
}
