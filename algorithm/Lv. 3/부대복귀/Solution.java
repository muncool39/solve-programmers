import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i=1;i<=n;i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<roads.length;i++) {
            int[] r = roads[i];
            list[r[0]].add(r[1]);
            list[r[1]].add(r[0]);
        }
        int[] D = new int[n+1];
        boolean[] visited = new boolean[n+1];
        visited[destination] = true;
        
        Queue<Integer> que = new LinkedList<>();
        que.add(destination);
        while(!que.isEmpty()) {
            int now = que.poll();
            int nextD = D[now] + 1;
            for(int next : list[now]) {
                if(visited[next]) {
                    continue;
                }
                visited[next] = true;
                D[next] = nextD;
                que.add(next);
            }
        }
        int[] answer = new int[sources.length];
        for(int i=0;i<sources.length;i++) {
            answer[i] = D[sources[i]];
            if(D[sources[i]] == 0 && sources[i] != destination) {
                answer[i] = -1;
            }
        }
        return answer;
    }
}