class Solution {  
    public int solution(int[][] board) {
        int mx = board.length;
        int my = board[0].length;
        int maxArea = lineCheck(board, mx, my);
        for(int x=1;x<mx;x++) {
            for(int y=1;y<my;y++) {
                if(board[x][y] == 0) {
                    continue;
                }
                int min = Math.min(board[x-1][y-1], Math.min(board[x][y-1], board[x-1][y]));
                board[x][y] = min + 1;
                maxArea = Math.max(maxArea, board[x][y]);
            }
        }
        return maxArea * maxArea;
    }
    private int lineCheck(int[][] board, int mx, int my) {
        for(int x=0;x<mx;x++) {
            if(board[x][0] == 1) return 1;
        }
        for(int y=0;y<my;y++) {
            if(board[0][y] == 1) return 1;
        }
        return 0;
    }
}