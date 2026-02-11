import java.util.*;

class Solution {
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    
    HashMap<String, Integer> numMap = new HashMap<>() {{
        put("cpp", 1);
        put("java", 2);
        put("python", 3);
        put("backend", 10);
        put("frontend", 20);
        put("junior", 100);
        put("senior", 200);
        put("chicken", 1000);
        put("pizza", 2000);
        put("-", 0);
    }};
    
    public int[] solution(String[] info, String[] query) {
        for(String human : info) {
            combine(human.split(" "), 0, 0, Integer.parseInt(human.split(" ")[4]));
        }
        for(ArrayList<Integer> list : map.values()) {
            Collections.sort(list);
        
        }
        int[] answer = new int[query.length];
        for(int i=0;i<query.length;i++) {
            String qinfo = query[i].replace("and ", "");
            String[] q = qinfo.split(" ");
            int key = getNum(q);
            ArrayList<Integer> list = map.get(key);
            if(list == null) {
                answer[i] = 0;
                continue;
            }
            int min = findBoundary(list, Integer.parseInt(q[4]));
            answer[i] = list.size() - min;
        }
        return answer;
    }
    
    private int findBoundary(ArrayList<Integer> list, int target) {
        int min = 0;
        int max = list.size();
        while(min < max) {
            int mid = (min + max) / 2;
            int score = list.get(mid);
            if(score < target) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }
    
    private int getNum(String[] info) {
        int num = 0;
        for(int i=0;i<4;i++) {
            num += numMap.get(info[i]);
        }
        return num;
    }
    
    private void combine(String[] info, int index, int key, int score) {
        if(index == 4) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }
        combine(info, index+1, key+numMap.get(info[index]), score);
        combine(info, index+1, key, score);
    }
}
