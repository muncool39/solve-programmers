class Solution {
    public int[] solution(int n) {
        int[][] list = new int[n][n];
        int max = n*(n+1)/2;
        int number = 1;
        int count = n;
        int x = -1, y = 0;
        boolean down = true, up = false;
        while(number <= max) {
            if(down) {
                for(int i=0;i<count;i++) {
                    list[++x][y] = number++; 
                }
                down = false;
            } else if(up) {
                for(int i=0;i<count;i++) {
                    list[--x][--y] = number++;
                }
                up = false;
                down = true;
            } else {
                for(int i=0;i<count;i++) {
                    list[x][++y] = number++;
                }
                up = true;
            }
            count--;
        }
        
        int answer[] = new int[max];
        int index = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<=i;j++) {
                answer[index++] = list[i][j];
            }
        }
        return answer;
    }
}