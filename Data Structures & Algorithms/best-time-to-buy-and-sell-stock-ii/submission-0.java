class Solution {
    public int maxProfit(int[] prices) {
        // [7], profit = 0
        // [1], profit = 0
        // [5], profit = 4
        // [3], profit = 4
        // [6], profit = 7
        // [4], profit = 7
        int res = 0;
        int curr = Integer.MAX_VALUE;
        for (int price : prices) {
            if (curr < price) {
                res += (price - curr);
            }
            curr = price;
        }

        return res;
    }
}