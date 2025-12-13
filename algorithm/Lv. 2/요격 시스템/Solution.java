import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> {
            return o1[0] - o2[0];
        });
        for(int[] t : targets) {
            que.add(t);
        }
        int count = 1;
        int back = que.poll()[1];
        while(que.size() > 0) {
            int[] now = que.poll();
            if(now[0] >= back) {
                count++;
                back = now[1];
            } else if(now[1] < back) {
                back = now[1];
            }
        }
        return count;
    }
}
