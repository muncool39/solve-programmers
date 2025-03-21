import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            return (o1[0] == o2[0]) ? o1[1] - o2[1] : o1[0] - o2[0];
        });
        
        int last = routes[0][1];
        int answer = 1;
        
        for(int[] r : routes) {
            int in = r[0];
            int out = r[1];
            if(in <= last) {
                last = (last < out) ? last : out;
            } else {
                answer++;
                last = out;
            }
        }
        return answer;
    }
}