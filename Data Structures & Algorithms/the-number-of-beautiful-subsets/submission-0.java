class Solution {
    int res = 0;
    int[] nums;
    int k;

    public int beautifulSubsets(int[] nums, int k) {
        // all subsets
        // [1,2,3]
        // [1] [2] [3] [1,2] [2,3] [1,2,3]
        // n * (n-1) / 2

        // not vaild subset
        // find two chosen values have difference exactly k.
        // [1,2] -> containing [1,2] would be invaildated.

        //                  [1,2,3,4,5]
        //          [1,2,3,4]       [2,3,4,5]
        //      [1,2,3]     [2,3,4]     [3,4,5]
        //   [1,2]    [2,3]     [3,4]       [4,5]
        // 1        2       3           4               5

        // (1) include or not include(two chosens)
        // 1 -> include
        //   \
        //      not include

        // (2) if now is already invalid, put in res
        // if not, check invalid
        
        // diff k -> use set
        // if set.contains(curr - k) or set.contains(curr + k)
        this.nums = nums;
        this.k = k;

        backTrack(0, new HashMap<>(), true);
        return res - 1; // exclude the empty subset
    }

    private void backTrack(int i, HashMap<Integer, Integer> chosen, boolean valid) {
        // terminate condition
        if (i == nums.length) {
            if (valid) res++;
            return;
        }

        // not include
        backTrack(i + 1, chosen, valid);

        // include
        boolean valid2 = valid;
        
        // check
        if (chosen.containsKey(nums[i] - k) || chosen.containsKey(nums[i] + k)) {
            valid2 = false;
        }

        chosen.put(nums[i], chosen.getOrDefault(nums[i], 0) + 1);

        backTrack(i + 1, chosen, valid2);

        chosen.put(nums[i], chosen.get(nums[i]) - 1);

        if (chosen.get(nums[i]) == 0) {
            chosen.remove(nums[i]);
        }

    }
}
