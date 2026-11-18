class Solution {
    List<List<Integer>> res;
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.res = new ArrayList<>();
        this.nums = nums;

        backTrack(0, new ArrayList<>());

        return res;    
    }

    private void backTrack(int idx, List<Integer> path) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        backTrack(idx + 1, path);

        path.add(nums[idx]);
        backTrack(idx + 1, path);
        path.remove(path.size() - 1);
    }
}
