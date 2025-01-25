class Solution {
    boolean[] visited;
    int[][] link;
    int max;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        link = computers.clone();
        max = n;
        int count = 0;
        for(int i=0;i<n;i++) {
            if(visited[i]) {
                continue;
            }
            count++;
            visited[i] = true;
            DFS(i);
        }
        return count;
    }
    
    private void DFS(int now) {
        for(int i=0;i<max;i++) {
            if(visited[i] || link[i][now]==0) {
                continue;
            }
            visited[i] = true;
            DFS(i);
        }
    }
}