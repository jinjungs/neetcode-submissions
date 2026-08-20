class Solution {
    private String s;
    private int n;

    public int countSubstrings(String s) {
        this.s = s;
        this.n = s.length();

        int res = 0;

        for (int i = 0; i < n; i++) {
            // odd
            res += expand(i, i);

            // even
            res += expand(i, i + 1);
        }

        return res;
    }

    private int expand(int l, int r) {
        int cnt = 0;

        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            cnt++;
            l--;
            r++;
        }

        return cnt;
    }
}