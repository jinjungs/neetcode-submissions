class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;

        int write = 2;

        for (int read = 2; read < n; read++) {
            if (nums[read] != nums[write-2]) {
                nums[write] = nums[read];
                write++;
            }
        }

        return write;
    }
}