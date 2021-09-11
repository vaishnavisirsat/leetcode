class Solution {
    public boolean canFinish(int n, int[][] P) {
    // Build a graph
    List<List<Integer>> adj = new ArrayList<>(n); // 0 to n - 1
    for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
    for (int[] edge : P) adj.get(edge[1]).add(edge[0]);
​
    // 0: Not processed, 1: Processing, 2: Processed
    List<Integer> state = new ArrayList<>(Collections.nCopies(n, 0));
    for (int i = 0; i < n; i++) {
      if (state.get(i) == 0 && DFS(adj, state, i)) return false;
    }
    return true;
  }
​
  private static boolean DFS(List<List<Integer>> adj, List<Integer> state, int vertex) {
    if (state.get(vertex) == 1) return true; // Cycle detected
    state.set(vertex, 1); // Processing
    for (int neighbor : adj.get(vertex)) {
      if (state.get(neighbor) != 2 && DFS(adj, state, neighbor)) return true;
    }
    state.set(vertex, 2); // Done processing
    return false;
  }
}
