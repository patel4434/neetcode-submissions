class Solution {

    public boolean validTree(int n, int[][] edges) {

        // A tree with n nodes must have n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build undirected graph
        for (int[] edge : edges) {

            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];

        dfs(graph, visited, 0);

        // Check if every node was visited
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }

    private void dfs(
            List<List<Integer>> graph,
            boolean[] visited,
            int node) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }
}