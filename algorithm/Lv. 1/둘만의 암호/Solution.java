import java.util.*;
class Solution {
    String[] alpha = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    HashMap<Integer, String> alphaMap = new HashMap<>();
    HashMap<String, Integer> alphaIndexMap = new HashMap<>();
    public String solution(String s, String skip, int index) {
        int i = 0;
        for(String a : alpha) {
            if(skip.contains(a)) continue;
            alphaMap.put(i, a);
            alphaIndexMap.put(a, i);
            i++;
        }
        StringBuilder sb = new StringBuilder("");
        for(String ss : s.split("")) {
            sb.append(code(ss, index));
        }
        return sb.toString();
    }
    
    private String code(String a, int index) {
        int aIndex = alphaIndexMap.get(a);
        int nextIndex = aIndex + index;
        if(nextIndex >= alphaMap.size()) {
            nextIndex = nextIndex % alphaMap.size(); //-로 하면 3,17,18.. 에러
        }
        return alphaMap.get(nextIndex);
    }
}