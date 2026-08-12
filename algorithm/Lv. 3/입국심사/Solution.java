import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long min = 0;
        long max = times[times.length - 1] * (long) n;
        while(min <= max) {
            long mid = (min + max) / 2;
            long total = 0;
            for(int i=0;i<times.length;i++) {
                total += mid / times[i];
            }
            if(total < n) {
                min = mid + 1;
            } else {
                max = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}