import java.util.*;

class Solution {
    int n, m;
    int[] pipe;
    boolean[][] checked;
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        pipe = new int[m];
        checked = new boolean[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(checked[i][j] || land[i][j] == 0) {
                    continue;
                }
                checked[i][j] = true;
                explore(land, new int[]{i, j});
            }
        }
        int answer = 0;
        for(int p : pipe) {
            answer = Math.max(answer, p);
        }
        return answer;
    }
    
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public void explore(int[][] land, int[] start) {
        Queue<int[]> que = new LinkedList<>();
        que.add(start);
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        while(que.size() > 0) {
            int[] now = que.poll();
            count++;
            set.add(now[1]);
            for(int[] d : dir) {
                int nn = now[0] + d[0];
                int nm = now[1] + d[1];
                if(nn<0 || nn>=n || nm<0 || nm>=m || land[nn][nm] == 0 || checked[nn][nm]) {
                    continue;
                }
                checked[nn][nm] = true;
                que.add(new int[]{nn, nm});
            }
        }
        for(int s : set) {
            pipe[s]+=count;
        }
    }
}
