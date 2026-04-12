import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        for(int w : works) {
            que.add(w);
        }
        while(n > 0 && que.size() > 0) {
            int w = que.poll();
            w--;
            n--;
            if(w > 0) {
                que.add(w);
            }
        }
        long answer = 0;
        while(que.size() > 0) {
            answer+=(long) Math.pow(que.poll(), 2);
        }
        return answer;
    }
}
