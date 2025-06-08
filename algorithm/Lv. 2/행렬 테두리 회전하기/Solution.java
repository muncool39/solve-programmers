class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows+1][columns+1];
        int number = 1;
        for(int i=1;i<=rows;i++) {
            for(int j=1;j<=columns;j++) {
                map[i][j] = number++;
            }
        }
        int qsize = queries.length;
        int ans[] = new int[qsize];
        for(int i=0;i<qsize;i++) {
            int[][] org = copy(map, rows+1, columns+1);
            spin(map, org, queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
            ans[i] = findMin(map, queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }
        return ans;
    }
    
    private int[][] copy(int[][] map, int x, int y) {
        int[][] cmap = new int[x][y];
        for(int i=1;i<x;i++) {
            cmap[i] = map[i].clone();
        }
        return cmap;
    }
    
    private void spin(int[][] map, int[][] original, int x1, int y1, int x2, int y2) {
        for(int y=y1+1;y<=y2;y++) {
            map[x1][y] = original[x1][y-1];
            map[x2][y-1] = original[x2][y];
        }
        for(int x=x1+1;x<=x2;x++) {
            map[x][y2] = original[x-1][y2];
            map[x-1][y1] = original[x][y1];
        }
    }
    
    private int findMin(int[][] map, int x1, int y1, int x2, int y2) {
        int min = map[x1][y1];
        for(int x=x1;x<=x2;x++) {
            if(map[x][y1] < min) min = map[x][y1];
            if(map[x][y2] < min) min = map[x][y2];
        }
        for(int y=y1;y<=y2;y++) {
            if(map[x1][y] < min) min = map[x1][y];
            if(map[x2][y] < min) min = map[x2][y];
        }
        return min;
    }
}