class Solution {
    int[][] square;
    int[] count = new int[2];
    public int[] solution(int[][] arr) {
        square = new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++) {
            square[i] = arr[i].clone();
        }
        dfs(0, arr.length, 0, arr.length);
        return count;
    }
    public void dfs(int xs, int xe, int ys, int ye) {
        if(xe<=xs || ye<=ys) return;
        if(isSameValue(xs, xe, ys, ye, square[xs][ys])) {
            count[square[xs][ys]]++;
            return;
        }
        int midx = (xs + xe) / 2;
        int midy = (ys + ye) / 2;
        dfs(xs, midx, ys, midy); 
        dfs(xs, midx, midy, ye);
        dfs(midx, xe, ys, midy);
        dfs(midx, xe, midy, ye);
    }
    public boolean isSameValue(int xs, int xe, int ys, int ye, int S) {
        for(int i=xs;i<xe;i++) {
            for(int j=ys;j<ye;j++) {
                if(S!=square[i][j]) return false;
            }
        }
        return true;
    }
}