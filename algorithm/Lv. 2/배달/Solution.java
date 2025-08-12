import java.util.*;

class Solution {
    
    public int solution(int N, int[][] road, int K) {
        HashSet<Integer>[] path = new HashSet[N+1];
        for(int i=0;i<=N;i++) {
            path[i] = new HashSet<>();
        }
        int[][] pathTime = new int[N+1][N+1];
        for(int[] r : road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];
            if(pathTime[a][b] > 0) {
                c = Math.min(pathTime[a][b], c);
            }
            pathTime[a][b] = c;
            pathTime[b][a] = c;
            path[a].add(b);
            path[b].add(a);
        }
        
        int[] md = new int[N+1];
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        while(que.size() > 0) {
            int now = que.poll();
            for(int next : path[now]) {
                if(next == 1) {
                    continue;
                }
                int time = md[now] + pathTime[now][next];
                if(md[next] > 0 && md[next] < time) {
                    continue;
                }
                md[next] = time;
                que.add(next);
            }
        }
        
        int ans = 1;
        for(int i=2;i<=N;i++) {
            if(md[i] <= K) {
                ans++;
            }
        }
        return ans;
    }
}
