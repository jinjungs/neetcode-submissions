class Solution {
    List<String> res = new ArrayList<>();
    String digits;

    Map<Character, List<Character>> dict = Map.of(
        '2', List.of('a','b','c'),
        '3', List.of('d','e','f'),
        '4', List.of('g','h','i'),
        '5', List.of('j','k','l'),
        '6', List.of('m','n','o'),
        '7', List.of('p','q','r','s'),
        '8', List.of('t','u', 'v'),
        '9', List.of('w','x','y','z')
    );

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        if (digits == null || digits.length() == 0) return res;
        backTrack(0, new StringBuilder());
        return res;
    }

    private void backTrack(int idx, StringBuilder sb) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }

        for (char c : dict.get(digits.charAt(idx))) {
            sb.append(c);
            backTrack(idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
