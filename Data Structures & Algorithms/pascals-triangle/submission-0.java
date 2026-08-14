class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));

        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> prev = res.get(i);
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= prev.size(); j++) {
                if (j == 0 || j == prev.size()) {
                    curr.add(1);
                } else {
                    curr.add(prev.get(j-1) + prev.get(j));
                }
            }
            res.add(curr);
        }

        return res;
    }
}