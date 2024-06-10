import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int a = bfs(maps, maps.length, maps[0].length);
        return (a>0)?a:-1;
    }
    
    public int bfs(int[][] maps, int n, int m) {
        int[][] next = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int[][] counts = new int[n][m];
        counts[0][0] = 1;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0});
        while(!que.isEmpty()) {
            int[] now = que.poll();
            int nowcount = counts[now[0]][now[1]];
            for(int i=0;i<4;i++) {
                int nx = now[0] + next[i][0];
                int ny = now[1] + next[i][1];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(maps[nx][ny]==0 || counts[nx][ny]!=0) continue;
                que.add(new int[]{nx, ny});
                counts[nx][ny] = nowcount + 1;
            }
        }
        return counts[n-1][m-1];
    }
}
