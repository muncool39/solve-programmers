import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        TreeMap<Integer, Integer> timeMap = new TreeMap<>();
        TreeMap<Integer, Integer> totalMap = new TreeMap<>();
        boolean[] out = new boolean[10000];
        for(String record : records) {
            String[] el = record.split(" ");
            int carNum = Integer.parseInt(el[1]);
            int now = getMinute(el[0].split(":"));
            if(el[2].equals("OUT")) {
                out[carNum] = true;
                totalMap.put(carNum, totalMap.get(carNum)+now-timeMap.get(carNum));
            } else {
                out[carNum] = false;
                timeMap.put(carNum, now);
                totalMap.putIfAbsent(carNum, 0);
            }
        }
        int max = getMinute("23:59".split(":"));
        int[] answer = new int[timeMap.size()];
        int index = 0;
        int basicT = fees[0]; int basicP = fees[1];
        double unitT = fees[2]*1.0; int unitP = fees[3];
        for (Map.Entry<Integer, Integer> entry : totalMap.entrySet()) {
            int carNum = entry.getKey();
            int useTime = entry.getValue();
            if(!out[carNum]) {
                useTime += (max - timeMap.get(carNum));
            }
            answer[index] = basicP;
            if(useTime > basicT) {
                answer[index]+= Math.ceil((useTime-basicT)/unitT) * unitP;
            }
            index++;
        }
        return answer;
    }
    public int getMinute(String[] time) {
        return Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
    }
}