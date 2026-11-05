class Solution {
    int[] nums;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;    
        backTrack(0, new ArrayList<>());
        return res;
    }

    private void backTrack(int idx, List<Integer> path) {
        res.add(new ArrayList<>(path));

        if (idx == nums.length) return;

        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            backTrack(i+1, path);
            path.remove(path.size() - 1);
        }
    }
}
