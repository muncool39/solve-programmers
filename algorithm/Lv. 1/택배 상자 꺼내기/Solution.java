import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        TreeSet<Integer>[] set = new TreeSet[w];
        for(int i=0;i<w;i++) {
            set[i] = new TreeSet<>();
        }
        int idx = 0;
        int wei = 1;
        int tIdx = -1;
        for(int i=1;i<=n;i++) {
            set[idx].add(i);
            if(i==num) {
                tIdx = idx;
            }
            if(tIdx == idx) {
                answer++;
            }
            idx+=wei;
            if(idx == w) {
                wei*=-1;
                idx--;
            } else if(idx == -1) {
                wei*=-1;
                idx++;
            }
        }
        return answer;
    }
}
