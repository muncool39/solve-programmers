import java.util.*;

class Solution {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public int[] solution(String[] operations) {
        for(String operation : operations) {
            String[] op = operation.split(" ");
            if(op[0].equals("D") && map.size() > 0) {
                deleteWithCommand(op[1]);
            } else if(op[0].equals("I")) {
                int num = Integer.parseInt(op[1]);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return (map.size() > 0) ? new int[]{map.lastKey(), map.firstKey()} : new int[]{0, 0};
    }
    
    private void deleteWithCommand(String command) {
        int key = (command.equals("1")) ? map.lastKey() : map.firstKey();
        if(map.get(key) == 1) {
            map.remove(key);
        } else {
            map.replace(key, map.get(key) - 1);
        }
    }
    
}