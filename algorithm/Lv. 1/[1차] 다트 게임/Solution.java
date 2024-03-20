import java.util.*;
class Solution {
    int[] scores = new int[3];
    HashMap<String, Integer> bonuss = new HashMap<>() {{
        put("S", 1);
        put("D", 2);
        put("T", 3);
    }};
    HashMap<String, Integer> options = new HashMap<>() {{
        put("*", 2);
        put("#", -1);
    }};
    public int solution(String dartResult) {
        StringTokenizer st = new StringTokenizer(dartResult, "SDT*#", true);
        int index = -1;
        while(st.hasMoreTokens()){
            String now = st.nextToken();
            if(bonuss.containsKey(now)){
                calculateBonus(now, index);
                continue;
            }
            if(options.containsKey(now)){
                calculateOption(now, index);
                continue;
            }
            index++;
            scores[index] = Integer.parseInt(now);
        }
        return Arrays.stream(scores).sum();
    }
    
    private void calculateBonus(String bonus, int index){
        int q = bonuss.get(bonus);
        scores[index] = (int)Math.pow(scores[index], q);
    }
    
    private void calculateOption(String option, int index){
        int effect = options.get(option);
        scores[index] *= effect;
        if(effect>0 && index>0) scores[index-1] *= effect;
    }
}