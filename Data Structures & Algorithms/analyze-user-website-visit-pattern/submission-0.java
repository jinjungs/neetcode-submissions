class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // bob: [(1,home), (2, about), (3, career)], alice: [...]
        // home about career -> home, home#about, home#about#career, 
        // cart maps home
        // home about career
        
        int n = username.length;
        Map<String, List<Integer>> nameToTimeIdx = new HashMap<>();

        for (int i = 0; i < n; i++) {
            nameToTimeIdx.putIfAbsent(username[i], new ArrayList<>());
            nameToTimeIdx.get(username[i]).add(i);
        }

        Map<String, Integer> scores = new HashMap<>();

        for (String key: nameToTimeIdx.keySet()) {
            List<Integer> indices = nameToTimeIdx.get(key);
            indices.sort((a, b) -> timestamp[a] - timestamp[b]);
            
            // make pattern of 3 website
            Set<String> seen = new HashSet<>();
            int size = indices.size();

            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    for (int k = j + 1; k < size; k++) {
                        String pattern = website[indices.get(i)] + "#" + website[indices.get(j)] + "#" + website[indices.get(k)];
                        seen.add(pattern);
                    }
                }
            }

            for (String p : seen) {
                scores.put(p, scores.getOrDefault(p, 0) + 1);
            }
        }

        // sort by lexicographical order
        List<String> keyList = new ArrayList<>(scores.keySet());
        keyList.sort(null);

        String best = "";
        int bestScore = 0;

        // return largest score
        for (String key: keyList) {
            int score = scores.get(key);
            if (score > bestScore) {
                bestScore = score;
                best = key;
            }
        }

        return Arrays.asList(best.split("#"));
    }
}