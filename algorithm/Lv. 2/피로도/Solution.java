class Solution {
    int end, max = 0;
    int[][] cost;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        cost = dungeons;
        end = dungeons.length;
        dfs(0, k);
        return max;
    }
    
    private void dfs(int deep, int fatigue) {
        if(deep > end) return;
        if(deep > max) max = deep;
        for(int index=0;index<end;index++) {
            if(visited[index]) continue;
            if(fatigue < cost[index][0]) continue;
            visited[index] = true;
            dfs(deep + 1, fatigue-cost[index][1]);
            visited[index] = false;
        }
    }
}