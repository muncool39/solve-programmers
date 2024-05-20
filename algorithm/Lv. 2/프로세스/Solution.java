import java.util.*;
class Solution {
    Queue<int[]> que = new LinkedList<>();
    int[] count = new int[10];
    public int solution(int[] priorities, int location) {
        for(int i=0;i<priorities.length;i++) {
            que.add(new int[]{i, priorities[i]});
            count[priorities[i]]++;
        }
        int answer = doProcess(location);
        return answer;
    }
    
    private int doProcess(int target) {
        int turn = 0;
        while(!que.isEmpty()) {
            int[] process = que.poll();
            int priority = process[1];
            if(checkFirst(priority+1)) {
                que.add(process);
            }else {
                count[priority]--;
                turn++;
                if(process[0]==target) return turn;
            }
        }
        return -1;
    }
    
    private boolean checkFirst(int priority) {
        for(int i=priority;i<=9;i++) {
            if(count[i]>0) return true;
        }
        return false;
    }
}