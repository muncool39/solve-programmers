class Solution {
    public int solution(int[] mats, String[][] park) {
        int xs = park.length;
        int ys = park[0].length;
        int[][] place = new int[xs][ys];
        for(int i=0;i<ys;i++) {
            place[0][i] = (park[0][i].equals("-1")) ? 1 : 0;
        }
        for(int i=0;i<xs;i++) {
            place[i][0] = (park[i][0].equals("-1")) ? 1 : 0;
        }
        int maxArea = 0;
        for(int x=1;x<xs;x++) {
            for(int y=1;y<ys;y++) {
                if(!park[x][y].equals("-1")) {
                    continue;
                }
                place[x][y] = Math.min(place[x-1][y-1], 
                                       Math.min(place[x-1][y], place[x][y-1])) + 1;
                if(maxArea < place[x][y]) {
                    maxArea = place[x][y];
                }
            }
        }
        int ans = -1;
        for(int m : mats) {
            if(m > ans && m <= maxArea) {
                ans = m;
            }
        }
        return ans;
    }
}