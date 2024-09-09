import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        long sum1 = 0; long sum2 = 0;
        for(int i=0;i<queue1.length;i++) {
            sum1+=queue1[i];
            que1.add(queue1[i]);
            sum2+=queue2[i];
            que2.add(queue2[i]);
        }
        int maxCount = queue1.length * 3;
        int count = 0;
        while(sum1!=sum2 && count<maxCount) {
            if(sum1 < sum2) {
                int el = que2.poll();
                que1.add(el);
                sum1+=el;
                sum2-=el;
            } else if(sum1 > sum2) {
                int el = que1.poll();
                que2.add(el);
                sum2+=el;
                sum1-=el;
            }
            count++;
            if(que1.isEmpty() || que2.isEmpty()) return -1;
        }
        return (sum1==sum2)?count:-1;
    }
}