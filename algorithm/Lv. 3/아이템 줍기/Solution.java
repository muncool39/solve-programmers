import java.util.*;

class Solution {
    int[][] map = new int[102][102];
    boolean[][] in = new boolean[102][102];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int[] r : rectangle) {
            draw(r[0]*2, r[1]*2, r[2]*2, r[3]*2);
            fill(r[0]*2, r[1]*2, r[2]*2, r[3]*2);
        }
        return find(characterX*2, characterY*2, itemX*2, itemY*2);
    }
    
    private int find(int cx, int cy, int ix, int iy) {
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{cx, cy});
        
        int[][] root = new int[102][102];
        root[cy][cx] = 1;
        
        while(que.size()>0 && root[iy][ix]<=0) {
            int[] now = que.poll();
            int x = now[0];
            int y = now[1];
            for(int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];
                if(nx>102 || ny>102 || nx<0 || ny<0) continue;
                if(root[ny][nx]>0 || map[ny][nx]==0) continue;
                que.add(new int[]{nx, ny});
                root[ny][nx]+=(root[y][x]+1);
            }
        }
        return (root[iy][ix] - 1)/2;
    }
    
    private void draw(int sx, int sy, int ex, int ey) {
        for(int i=sx;i<=ex;i++) {
            if(!in[sy][i]) map[sy][i] = 1;
            if(!in[ey][i]) map[ey][i] = 1;
        }
        for(int i=sy;i<=ey;i++) {
            if(!in[i][sx]) map[i][sx] = 1;
            if(!in[i][ex]) map[i][ex] = 1;
        }
    }
    
    private void fill(int sx, int sy, int ex, int ey) {
        for(int i=sx+1;i<ex;i++) {
            for(int j=sy+1;j<ey;j++) {
                in[j][i] = true;
                if(map[j][i]==1) map[j][i] = 0;
            }
        }
    }
}