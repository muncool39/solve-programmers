import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int maxsize = citations.length;
        int max = 0;
        for(int i=0;i<maxsize;i++) {
            int h = Math.min(citations[i], maxsize - i);
            if(max > h) break;
            max = h;
        }
        return max;
    }
}