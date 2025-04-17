import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int h = maps.length;
        int w = maps[0].length();
        int[] start = findStart(h, w, maps);
        return findRoot(h, w, start, maps);
    }

    private int findRoot(int h, int w, int[] start, String[] maps) {
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{start[0], start[1], 0});
        
        boolean[][] visited = new boolean[h][w];
        visited[start[0]][start[1]] = true;
        
        boolean meetL = false;
        
        while(que.size() > 0) {
            int[] now = que.poll();
            int nowH = now[0];
            int nowW = now[1];
            int nextD = now[2] + 1;
            
            for(int[] d : dir) {
                int nextH = nowH + d[0];
                int nextW = nowW + d[1];
                if(nextH>=h || nextH<0 || nextW>=w || nextW<0) {
                    continue;
                }
                if(maps[nextH].charAt(nextW)=='X' || visited[nextH][nextW]) {
                    continue;
                }
                if(maps[nextH].charAt(nextW)=='L') {
                    que.clear();
                    que.add(new int[]{nextH, nextW, nextD});
                    
                    visited = new boolean[h][w];
                    visited[nextH][nextW] = true;
                    
                    meetL = true;
                    break;
                    
                } else if(maps[nextH].charAt(nextW)=='E' && meetL) {
                    return nextD;
                }
                visited[nextH][nextW] = true;
                que.add(new int[]{nextH, nextW, nextD});
            }
        }
        return -1;
    }
    
    private int[] findStart(int h, int w, String[] maps) {
        for(int i=0;i<h;i++) {
            for(int j=0;j<w;j++) {
                if(maps[i].charAt(j)=='S') return new int[]{i, j};
            }
        }
        return new int[]{0, 0};
    }
}