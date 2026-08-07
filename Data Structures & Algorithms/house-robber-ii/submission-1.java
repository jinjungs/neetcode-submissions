class Solution {
    public int rob(int[] nums) {
        if (nums.length <= 1) return nums[0];
        
        int prevPrev = 0;
        int prev = nums[0];

        for (int i = 1; i < nums.length - 1; i++) {
            int curr = Math.max(prevPrev + nums[i], prev);
            prevPrev = prev;
            prev = curr;
        }

        int one = prev;
        prevPrev = 0;
        prev = nums[1];

        for (int i = 2; i < nums.length; i++) {
            int curr = Math.max(prevPrev + nums[i], prev);
            prevPrev = prev;
            prev = curr;
        }

        int two = prev;

        return Math.max(one, two);
    }
}
