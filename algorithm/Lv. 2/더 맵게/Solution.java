import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int sco : scoville) {
            que.add(sco);
        }
        while(que.peek()<K && que.size()>1) {
            que.offer(que.poll() + (que.poll() * 2));
            answer++;
        }
        if(que.peek()<K) return -1;
        return answer;
    }
}