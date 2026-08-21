class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prev = new ArrayList<>();
        prev.add(triangle.get(0).get(0));
        
        int n = triangle.size();

        for (int i = 1; i < n; i++) {
            List<Integer> row = triangle.get(i);
            List<Integer> curr = new ArrayList<>();

            for (int j = 0; j < row.size(); j++) {
                int num = row.get(j);
                int add = Integer.MAX_VALUE;
                if (j < row.size() -1) {
                    add = Math.min(add, prev.get(j));
                }
                if (j > 0) {
                    add = Math.min(add, prev.get(j-1));
                }

                curr.add(num + add);
            }

            prev = curr;
        }

        int res = Integer.MAX_VALUE;
        for (int num : prev) {
            res = Math.min(res, num);
        }

        return res;
    }
}