import java.util.*;
class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> sumSet = new HashSet<>();
        int maxSize = elements.length;
        for(int interval=1;interval<=maxSize;interval++) {
            for(int start=0;start<maxSize;start++) {
                int now = start;
                int sum = 0;
                int count = interval;
                while(count > 0) {
                    count--;
                    sum+=elements[now];
                    now++;
                    if(now>=maxSize) now = maxSize%now;
                }
                sumSet.add(sum);
            }
        }
        return sumSet.size();
    }
}
