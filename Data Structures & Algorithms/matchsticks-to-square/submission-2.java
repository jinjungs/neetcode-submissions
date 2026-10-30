class Solution {
    int len;
    int[] matchsticks;
    int count;

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int match : matchsticks) {
            sum += match;
        }

        if (sum % 4 != 0) return false;

        this.matchsticks = matchsticks;
        this.len = sum / 4;
        this.count = 0;

        backTrack(0, 0);

        return count == 4;
    }

    public boolean backTrack(int idx, int path) {
        if (path > len) {
            return false;
        }

        if (path == len) {
            count++;

            if (count == 4 || backTrack(0, 0)) {
                return true;
            }

            count--;
            return false;
        }

        if (idx == matchsticks.length) {
            return false;
        }

        for (int i = idx; i < matchsticks.length; i++) {
            int match = matchsticks[i];
            
            if (match == -1) continue;
            
            matchsticks[i] = -1;

            if (backTrack(i + 1, path + match)) {
                return true;
            }

            matchsticks[i] = match;
        }

        return false;
    }
}