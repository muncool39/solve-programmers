import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] checked = new boolean[m][n];
        int areaNum = 0;
        int maxArea = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(checked[i][j] || picture[i][j] == 0) {
                    continue;
                }
                areaNum++;
                int area = 1;
                checked[i][j] = true;
                Queue<int[]> que = new LinkedList<>();
                que.add(new int[]{i, j});
                int color = picture[i][j];
                while(que.size() > 0) {
                    int[] now = que.poll();
                    for(int[] d : dir) {
                        int nx = now[0] + d[0];
                        int ny = now[1] + d[1];
                        if(nx < 0 || ny < 0 || nx >= m || ny >= n) {
                            continue;
                        }
                        if(checked[nx][ny] || picture[nx][ny] == 0 || picture[nx][ny] != color) {
                            continue;
                        }
                        checked[nx][ny] = true;
                        que.add(new int[]{nx, ny});
                        area++;
                    }
                }
                if(maxArea < area) {
                    maxArea = area;
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = areaNum;
        answer[1] = maxArea;
        return answer;
    }
}