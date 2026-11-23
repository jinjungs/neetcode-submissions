class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // {a:b} sum a has b ways

        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int num : nums) {
            Map<Integer, Integer> next = new HashMap<>();

            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int sum = entry.getKey();
                int ways = entry.getValue();

                next.merge(sum + num, ways, Integer::sum);
                next.merge(sum - num, ways, Integer::sum);
            }

            dp = next;
        }
        
        return dp.getOrDefault(target, 0);
    }
}
