class Solution {
    public int[] solution(int n, long left, long right) {
        long startCol = left/n;
        long startRow = left%n;
        long lastCol = right/n;
        long lastRow = right%n;
        long size = right-left+1;
        int[] answer = new int[(int)size];
        int index = 0;
        for(int i=(int)startCol;i<=lastCol;i++) {
            int sr = 0;
            int lr = n;
            if(i==startCol) sr = (int)startRow;
            if(i==lastCol) lr = (int)lastRow + 1;
            for(int j=sr;j<lr;j++) {
                answer[index] = Math.max(i, j) + 1;
                index++;
            }
        }
        return answer;
    }
}