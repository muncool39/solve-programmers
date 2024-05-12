import java.util.*;
import java.util.Map.Entry;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int we = 0;
        int index = 0;
        for(int i=0;i<progresses.length;i++) {
            int pnow = progresses[i];
            int snow = speeds[i];
            if(pnow+we*snow >= 100) {
                map.replace(index, map.get(index)+1);
                continue;
            }
            index++;
            we = 0;
            while(pnow < 100) {
                we++;
                pnow+=snow;
            }
            map.put(index, 1);
        }
        int[] answer = new int[map.size()];
        int i = 0;
        for(Entry<Integer, Integer> entry : map.entrySet()){
            answer[i] = entry.getValue();
            i++;
        }
        return answer;
    }
}