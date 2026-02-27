import java.util.*;

class Solution {
    HashSet<String> set = new HashSet<>();
    int length = 0;
    int answer = 201;
    public int solution(int[][] info, int n, int m) {
        length = info.length;
        steal(info, 0, 0, n, m, 0);
        return (answer == 201) ? -1 : answer;
    }
    
    private void steal(int[][] info, int a, int b, int n, int m, int index) {
        if(index == length) {
            answer = Math.min(answer, a);
            return;
        }
        String key = index + "/" + a + "/" + b;
        if(set.contains(key)) {
            return;
        }
        set.add(key);
        if(a + info[index][0] < n) {
            steal(info, a + info[index][0], b, n, m, index + 1);
        }
        if(b + info[index][1] < m) {
            steal(info, a, b + info[index][1], n, m, index + 1);
        }
    }
}
