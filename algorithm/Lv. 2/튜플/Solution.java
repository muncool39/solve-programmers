import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] sarr = s.substring(1, s.length()-2).replace("{", "").split("},");
        HashMap<String, Integer> map = new HashMap<>();
        for(String ts : sarr) {
            for(String tn : ts.split(",")) {
                map.put(tn, map.getOrDefault(tn, 0)+1);
            }
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int[] answer = new int[sarr.length];
        int i = 0;
        for(Map.Entry<String, Integer> entry : entryList){
            answer[i] = Integer.parseInt(entry.getKey());
            i++;
        }
        return answer;
    }
}