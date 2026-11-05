class Solution {
    int[] nums;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;

        backTrack(0, new ArrayList<>());
        return res;
    }

    private void backTrack(int idx, List<Integer> path) {
        res.add(new ArrayList<>(path));

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i-1] == nums[i]) continue;
            path.add(nums[i]);
            backTrack(i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
