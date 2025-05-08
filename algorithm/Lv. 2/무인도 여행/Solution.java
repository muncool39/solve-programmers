import java.util.*;

class Solution {
    boolean[][] visit;
    public int[] solution(String[] maps) {
        int maxX = maps.length;
        int maxY = maps[0].length();
        visit = new boolean[maxX][maxY];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<maxX;i++) {
            for(int j=0;j<maxY;j++) {
                if(visit[i][j] || maps[i].charAt(j)=='X') continue;
                visit[i][j] = true;
                list.add(getMaximumDays(maps, maxX, maxY, new int[]{i, j}));
            }
        }
        if(list.size()==0) return new int[]{-1};
        Collections.sort(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int getMaximumDays(String[] maps, int maxX, int maxY, int[] start) {
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> que = new LinkedList<>();
        que.add(start);
        int size = maps[start[0]].charAt(start[1]) - '0';
        while(que.size()>0) {
            int[] now = que.poll();
            for(int[] d : dir) {
                int nextX = now[0] + d[0];
                int nextY = now[1] + d[1];
                if(nextX>=maxX || nextY>=maxY || nextX<0 || nextY<0) continue;
                if(visit[nextX][nextY] || maps[nextX].charAt(nextY)=='X') continue;
                visit[nextX][nextY] = true;
                size+=(int)maps[nextX].charAt(nextY) - '0';
                que.add(new int[]{nextX, nextY});
            }
        }
        return size;
    }
}