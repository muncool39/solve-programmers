import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        return getResult(bridge_length, weight, truck_weights);
    }
    
    public int getResult(int size, int max, int[] trucks) {
        Queue<Integer> que = new LinkedList<>();
        que.add(trucks[0]);
        int now = trucks[0];
        int second = 1;
        for(int i=1;i<trucks.length;i++) {
            int count = 0;
            while(count<size) {
                if(que.size()==size) {
                    int out = que.poll();
                    now-=out;
                }
                if(trucks[i]+now <= max) break;
                que.add(0);
                second++; count++;
            }
            que.add(trucks[i]);
            now+=trucks[i];
            second++;
        }
        return second+size;
    }
}