class Solution {
    int solution(int[][] land) {
        for(int i=1;i<land.length;i++) {
            for(int j=0;j<4;j++) {
                land[i][j] += getLineMax(land[i-1], j);
            }
        }
        int answer = 0;
        for(int l : land[land.length-1]) {
            answer = (answer<l)?l:answer;
        }
        return answer;
    }
    int getLineMax(int[] line, int now) {
        int max = 0;
        for(int i=0;i<4;i++) {
            if(i==now) continue;
            max = (max<line[i])?line[i]:max;
        }
        return max;
    }
}