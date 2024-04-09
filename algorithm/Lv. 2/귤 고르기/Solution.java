import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int t : tangerine) {
            countMap.put(t, countMap.getOrDefault(t, 0) + 1);
        }
        List<Integer> countList = new ArrayList<>(countMap.values());
        Collections.sort(countList, Collections.reverseOrder());
        int tan = 0;
        while(k>0) {
            k-=countList.get(tan);
            tan++;
        }
        return tan;
    }
}