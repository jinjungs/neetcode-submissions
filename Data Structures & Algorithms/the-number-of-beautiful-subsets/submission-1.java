class Solution {
    int res;
    int[] nums;
    int k;
    HashMap<Integer, Integer> chosen;

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
        this.res = 0;
        this.nums = nums;
        this.k = k;
        this.chosen = new HashMap<>();

        backTrack(0);
        return res - 1; // exclude the empty subset
    }

    private void backTrack(int i) {
        // terminate condition
        if (i == nums.length) {
            res++;
            return;
        }

        // not include
        backTrack(i + 1);

        // include
        int value = nums[i];

        if (!chosen.containsKey(value - k) && !chosen.containsKey(value + k)) {
            chosen.put(value, chosen.getOrDefault(value, 0) + 1);
            
            backTrack(i + 1);

            chosen.put(value, chosen.get(value) - 1);

            if (chosen.get(value) == 0) {
                chosen.remove(value);
            }
        }

    }
}
