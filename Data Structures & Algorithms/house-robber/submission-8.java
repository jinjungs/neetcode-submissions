class Solution {
    public int rob(int[] nums) {
        int prev = 0;
        int prevPrev = 0;

        for (int num : nums) {
            int curr = Math.max(prevPrev + num, prev);
            prevPrev = prev;
            prev = curr;
        }

        return prev;
    }
}
