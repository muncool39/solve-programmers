import java.util.*;
class Solution {
    HashMap<String, Integer> keyCountMap = new HashMap<>(26);
    public int[] solution(String[] keymap, String[] targets) {
        for(String keys : keymap) {
            saveKeyMapCount(keys.split(""));
        }
        int[] answer = new int[targets.length];
        for(int i=0;i<targets.length;i++) {
            answer[i] = getPushCount(targets[i].split(""));
        }
        return answer;
    }
    private void saveKeyMapCount(String[] keyMap) {
        int count = 1;
        for(String key : keyMap) {
            int savedCount = keyCountMap.getOrDefault(key, 100);
            if(savedCount > count) {
                keyCountMap.put(key, count);
            }
            count++;
        }
    }
    private int getPushCount(String[] targetKeys) {
        int countSum = 0;
        for(String target : targetKeys) {
            if(!keyCountMap.containsKey(target)) return -1;
            countSum += keyCountMap.get(target);
        }
        return countSum;
    }
}