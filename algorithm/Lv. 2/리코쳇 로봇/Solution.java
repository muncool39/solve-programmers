import java.util.*;

class Solution {
    public int solution(String[] board) {
        int mx = board.length;
        int my = board[0].length();
        int[] s = getStart(mx, my, board);
        
        return BFS(mx, my, s[0], s[1], board);
    }
    
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    private int BFS(int mx, int my, int sx, int sy, String[] board) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{sx, sy, 0});
        
        boolean[][] visited = new boolean[mx][my];
        visited[sx][sy] = true;
        
        while(que.size() > 0) {
            int[] now = que.poll();
            int x = now[0];
            int y = now[1];
            int nc = now[2] + 1;
            
            for(int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];
                while(nx>=0 && ny>=0 && nx<mx && ny<my) {
                    if(board[nx].charAt(ny)=='D') {
                        break;
                    }
                    nx+=d[0];
                    ny+=d[1];
                }
                nx-=d[0];
                ny-=d[1];
                if(visited[nx][ny]) {
                    continue;
                }
                if(board[nx].charAt(ny)=='G') {
                    return nc;
                }
                visited[nx][ny] = true;
                que.add(new int[]{nx, ny, nc});
            }
        }
        return -1;
    }
    
    private int[] getStart(int mx, int my, String[] board) {
        for(int i=0;i<mx;i++) {
            for(int j=0;j<my;j++) {
                if(board[i].charAt(j) == 'R') return new int[]{i, j};
            }
        }
        return new int[]{0, 0};
    }
}