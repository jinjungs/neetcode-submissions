class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n]; // LIS when nums[i] will be the last element
        Arrays.fill(dp, 1);

        int[] lastIdx = new int[n];
        Arrays.fill(lastIdx, -1);

        int resIdx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    lastIdx[i] = j;
                }
            }
            // update max
            if (dp[resIdx] < dp[i]) {
                resIdx = i;
            }
        }

        // track res
        List<Integer> res = new ArrayList<>();
        int currIdx = resIdx;
        while (currIdx != -1) {            
            res.add(nums[currIdx]);
            currIdx = lastIdx[currIdx];
        }

        Collections.reverse(res);
        return res;
        
    }
}