class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    int target;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        backTrack(0, 0, new ArrayList<>());
        return res;
    }

    private void backTrack(int idx, int curr, List<Integer> path) {
        if (curr == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        // if (curr > target) return;

        for (int i = idx; i < nums.length; i++) {
            if (curr + nums[i] > target) continue;
            path.add(nums[i]);
            backTrack(i, curr + nums[i], path);
            path.remove(path.size() - 1);
        }

    }
}
