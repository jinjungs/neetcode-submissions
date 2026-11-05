class Solution {
    List<List<String>> res = new ArrayList<>();
    String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        backTrack(0, new ArrayList<>());
        return res;    
    }

    private void backTrack(int idx, List<String> path) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            String sub = s.substring(idx, i + 1);
            if (isPalindrome(sub)) {
                path.add(sub);
                backTrack(i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) return true;

        int l = 0;
        int r = str.length() - 1;

        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}
