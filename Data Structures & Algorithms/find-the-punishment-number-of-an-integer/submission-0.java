class Solution {
    public int punishmentNumber(int n) {
        int res = 0;
        for (int num = 1; num <= n; num++) {
            if (backTrack(0, String.valueOf(num * num), num, 0)) {
                res += num * num;
            }
        }
        return res;
    }

    public boolean backTrack(int idx, String s, int target, int curr) {
        // termination condition
        if (idx == s.length()) {
            return curr == target;
        }

        for (int i = idx; i < s.length(); i++) {
            int subNum = Integer.parseInt(s.substring(idx, i+1));
            if (subNum + curr > target) break;
            if (backTrack(i + 1, s, target, subNum + curr)) return true;
        }

        return false;
    }
}
