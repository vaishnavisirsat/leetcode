class Solution {
    boolean isBipartite(int[] col, int src, List<Integer>[] g) {
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        col[src]=0;
        while(!q.isEmpty()) {
            int i=q.poll();
            for(int j:g[i]) {
                if(col[j]==-1) {
                    q.add(j);
                    col[j]=1-col[i];
                }
                else if(col[j]==col[i])
                    return false;
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, Set<Integer>> hm=new HashMap<>();
        List<Integer>[] g=new ArrayList[n];
        for(int i=0;i<n;i++)
            g[i]=new ArrayList<>();
        for(int i=0;i<dislikes.length;i++) {
            int mi=Math.min(dislikes[i][0], dislikes[i][1])-1;
            int ma=Math.max(dislikes[i][0], dislikes[i][1])-1;
            g[mi].add(ma);
            g[ma].add(mi);
        }
        int[] col=new int[n];
        Arrays.fill(col, -1);
        for(int i=0;i<n;i++) {
            if(col[i]==-1)
                if(!isBipartite(col, i, g))
                    return false;
        }
        return true;
    }
}
