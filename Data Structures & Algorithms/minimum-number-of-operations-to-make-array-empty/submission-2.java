class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (int count: freq.values()) {
            if (count == 1) return -1;
            res += (count + 2) / 3;
        }

        return res;
    }
}