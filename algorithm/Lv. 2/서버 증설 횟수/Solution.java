import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int server = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int p : players) {
            if(p >= m && p >= m*(server+1)) {
                int plus = (p - m*server) / m;
                answer+=plus;
                server+=plus;
                int size = que.size();
                for(int i=1;i<k-size;i++) {
                    que.add(0);
                }
                que.add(plus);
            }
            if(que.size() > 0) {
                server-=que.poll();
            }
        }
        return answer;
    }
}