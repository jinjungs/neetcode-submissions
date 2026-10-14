class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        List<Map<Integer, Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(new HashMap<>());
        }

        dp.get(0).put(0, 1);

        // dp.get(i) : Map of num / ways that can get till i-1

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = dp.get(i);
            int curr = nums[i];
            for (int sum : map.keySet()) {
                int count = map.get(sum);
                dp.get(i+1).put(sum + curr, dp.get(i+1).getOrDefault(sum + curr, 0) + count);
                dp.get(i+1).put(sum - curr, dp.get(i+1).getOrDefault(sum - curr, 0) + count);
            }
        }

        return dp.get(n).getOrDefault(target, 0);
    }
}
