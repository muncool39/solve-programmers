import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] count = new int[y+1];
        count[y] = (x==y) ? 0 : -1;
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        while(que.size()>0) {
            int now = que.poll();
            int ar1 = now + n;
            int ar2 = now * 2;
            int ar3 = now * 3;
            if(ar1==y || ar2==y || ar3==y) {
                count[y] = count[now] + 1;
                break;
            }
            if(ar1 < y && count[ar1] < 1) {
                count[ar1] = count[now] + 1;
                que.add(ar1);
            }
            if(ar2 < y && count[ar2] < 1) {
                count[ar2] = count[now] + 1;
                que.add(ar2);
            }
            if(ar3 < y && count[ar3] < 1) {
                count[ar3] = count[now] + 1;
                que.add(ar3);
            }
        }
        return count[y];
    }
}