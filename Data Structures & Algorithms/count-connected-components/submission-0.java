class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int count =0;
        for(int i = 0; i< n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                count++;
                dfs(graph,visited,i);

            }
        }

        return count++;
    }

    private void dfs(List<List<Integer>> graph, boolean[] visited, int node ){

        visited[node] =true;

        for(int neighbor: graph.get(node)){
            if(!visited[neighbor]){
                dfs(graph,visited,neighbor);
            }
        }
    }
}
