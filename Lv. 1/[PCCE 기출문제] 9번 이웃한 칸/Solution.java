class Solution {
    int[] dh = {0, 1, -1, 0};
    int[] dw = {1, 0, 0, -1};
    public int solution(String[][] board, int h, int w) {
        int size = board.length;
        String color = board[h][w];
        int count = 0;
        for(int i=0;i<4;i++) {
            int nextH = h + dh[i];
            int nextW = w + dw[i];
            if(nextH >= size || nextW >=size || nextH<0 || nextW<0) continue;
            if(board[nextH][nextW].equals(color)) count++;
        }
        return count;
    }
}