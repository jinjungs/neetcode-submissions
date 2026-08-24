class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= prev.size(); j++) {
                int num = 0;
                if (j > 0) {
                    num += prev.get(j-1);
                }
                if (j < prev.size()) {
                    num += prev.get(j);
                }
                curr.add(num);                
            }
            prev = curr;
        }

        return prev;
    }
}