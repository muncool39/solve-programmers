import java.util.*;

class Solution {
    public long solution(int[] weights) {
        HashMap<Double, Integer> map = new HashMap<>();
        Arrays.sort(weights);
        long answer = 0;
        for(int w : weights) {
            double[] list = {w*1.0, (w*2.0)/3.0, (w*3.0)/4.0, w/2.0};
            for(double d : list) {
                if(map.containsKey(d)) {
                    answer+=map.get(d);
                }
            }
            map.put(w*1.0, map.getOrDefault(w*1.0, 0) + 1);
        }
        return answer;
    }
}