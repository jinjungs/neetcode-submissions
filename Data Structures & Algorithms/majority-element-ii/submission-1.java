class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int target = n / 3;

        int one = 0;
        int c1 = 0;
        int two = 0;
        int c2 = 0;

        for (int num : nums) {
            if (num == one) {
                c1++;
            } else if (num == two) {
                c2++;
            } else if (c1 == 0) {
                one = num;
                c1 = 1;
            } else if (c2 == 0) {
                two = num;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }

        // verify
        c1 = 0;
        c2 = 0;

        for (int num : nums) {
            if (num == one) {
                c1++;
            } else if (num == two) {
                c2++;
            }
        }

        List<Integer> res = new ArrayList<>();
        if (c1 > target) res.add(one);
        if (c2 > target) res.add(two);
        return res;
    }
}