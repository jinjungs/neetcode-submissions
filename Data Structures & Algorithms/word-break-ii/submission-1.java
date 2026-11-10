class Solution {
    Set<String> dict;
    String s;
    List<String>[] memo;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.dict = new HashSet<>();
        this.memo = new List[s.length() + 1];

        for (String word : wordDict) {
            dict.add(word);
        }

        return backTrack(0);
    }

    private List<String> backTrack(int idx) {
        if (memo[idx] != null) {
            return memo[idx];
        }

        List<String> sentences = new ArrayList<>();

        if (idx == s.length()) {
            sentences.add("");
            return memo[idx] = sentences;
        }

        for (int end = idx + 1; end <= s.length(); end++) {
            String word = s.substring(idx, end);

            if (!dict.contains(word)) continue;

            for (String suffix : backTrack(end)) {
                sentences.add(suffix.isEmpty() ? word : word + " " + suffix);
            }
        }

        return memo[idx] = sentences;
    }
}