import java.util.*;
class Solution {
    int count;
    boolean[] visited;
    ArrayList<Integer>[] list;
    public int solution(int n, int[][] wires) {
        list = new ArrayList[n+1];
        for(int i=1;i<=n;i++) {
            list[i] = new ArrayList<>();
        }
        for(int[] w : wires) {
            list[w[0]].add(w[1]);
            list[w[1]].add(w[0]);
        }
        int min = n;
        for(int i=1;i<=n;i++) {
            ArrayList<Integer> link = list[i];
            if(link.size()<2) {
                continue;
            }       
            for(int w : link) {
                count = 0;
                visited = new boolean[n+1];
                visited[i] = true;
                dfs(w);
                int d = Math.abs(count-Math.abs(n-count));
                min = (d < min) ? d : min;
            }
        }
        return min;
    }
    
    public void dfs(int next) {
        visited[next] = true;
        count++;
        ArrayList<Integer> link = list[next];
        for(int w : link) {
            if(visited[w]) {
                continue;
            }
            dfs(w);
        }
    }
}