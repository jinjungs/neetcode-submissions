class Solution {
    Map<Integer, List<Integer>> graph;
    List<Boolean> hasApple;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // make graph
        this.hasApple = hasApple;
        this.graph = new HashMap<>();

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.get(a).add(b);
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(b).add(a);
        }

        // minimum time
        /*
         0 - 1  - 4(T)
           \    \
            2(T)  5(T)
            /  \
          6     3
        */

        // dfs
        boolean[] visited = new boolean[n];
        return dfs(0, -1);
    }

    private int dfs(int node, int parent) {
        int time = 0;
        for (int nei : graph.getOrDefault(node, new ArrayList<>())) {
            if (nei != parent) {
                int childTime = dfs(nei, node);                
                if (childTime > 0 || hasApple.get(nei)) {
                    time += childTime + 2;
                }
            }
        }

        return time;
    }
}
