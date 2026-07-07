class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int target = n / 3;

        // max 2 values
        Arrays.sort(nums);
        
        List<Integer> res = new ArrayList<>();
        int currIdx = 0;
        for (int i = 1; i < n; i++) {
            if (nums[currIdx] != nums[i]) {
                if (i - currIdx > target) {
                    res.add(nums[currIdx]);
                }
                currIdx = i;
            }
        }
        if (n - currIdx > target) res.add(nums[currIdx]);

        return res;
    }
}