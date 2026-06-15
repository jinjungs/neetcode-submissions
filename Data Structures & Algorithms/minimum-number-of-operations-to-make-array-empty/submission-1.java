class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (int value: freq.values()) {
            if (value == 1) return -1;
            if (value % 3 == 0) {
                res += (value / 3);
            } else if (value % 3 == 1) {
                // 4, 7, 10, 13,
                // 2+2, 2+2+3, 2+2+3+3, 2+2+3+3+3
                int three = (value / 3) - 1;
                int two = (value - three * 3) / 2;
                res += (three + two);
            } else {
                // 2, 5, 8, 11, 14
                // 2, 2+3, 2+3+3, 2+3+3+3, 2+3+3+3+3
                int three = value / 3;
                int two = (value - three * 3) / 2;
                res += (three + two);
            }
        }

        return res;
    }
}