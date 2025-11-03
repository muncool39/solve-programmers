class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int member = schedules.length;
        int ans = member;
        for(int i=0;i<member;i++) {
            int dline = getTime(schedules[i]);
            int day = startday;
            for(int w=0;w<7;w++) {
                if(day < 6 && timelogs[i][w] > dline) {
                    ans--;
                    break;
                }
                day++;
                if(day == 8) {
                    day = 1;
                }
            }
        }
        return ans;
    }
    
    private int getTime(int time) {
        int h = time / 100;
        int m = time % 100;
        m+=10;
        if(m >= 60) {
            h++;
            m = m % 60;
        }
        return h*100 + m;
    }
}
