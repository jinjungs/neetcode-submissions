class Solution {
    List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        backTrack(0, s, new ArrayList<>());
        return res;
    }
    
    private void backTrack(int idx, String s, List<String> path) {
        // termnial
        if (idx == s.length() || path.size() == 4){
            if (idx == s.length() && path.size() == 4) {
                res.add(String.join(".", path));
            }
            return;
        }

        boolean leadingZero = (s.charAt(idx) - '0' == 0);

        for (int i = idx; i < Math.min(idx + 3, s.length()); i++) {
            if (leadingZero && i > idx) break;
            String curr = s.substring(idx, i + 1);
            if (Integer.parseInt(curr) > 255) break;

            path.add(curr);
            backTrack(i + 1, s, path);
            path.remove(path.size() - 1);
        }
    }
}