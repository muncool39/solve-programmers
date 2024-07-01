import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] R = new int[1000001];
        int[] L = new int[1000001];
        Set<Integer> set = new HashSet<>();
        for(int t : topping) {
            L[t]++;
            set.add(t);
        }
        int rcount = 0;
        int lcount = set.size();
        for(int t : topping) {
            R[t]++;
            L[t]--;
            if(R[t]==1) rcount++;
            if(L[t]==0) lcount--;
            if(rcount==lcount) answer++;
        }
        return answer;
    }
}