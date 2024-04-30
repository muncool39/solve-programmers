import java.util.*;
class Solution {
    String[] sarr;
    int size;
    HashMap<String, String> rightMap = new HashMap<>(){{
        put("(", ")");
        put("{", "}");
        put("[", "]");
    }};
    public int solution(String s) {
        size = s.length();
        sarr = s.split("");
        int count = 0;
        for(int i=0;i<size;i++) {
            if(isRight(i)) count++;
        }
        return count;
    }
    
    private boolean isRight(int index) {
        Stack<String> stack = new Stack<>();
        if(rightMap.containsValue(sarr[index])) return false;
        stack.push(sarr[index]);
        int count = 1;
        while(count < size) {
            index++;
            if(index==size) index = 0;
            count++;
            if(stack.size()>0 && rightMap.getOrDefault(stack.peek(), "0").equals(sarr[index])){
                stack.pop();
                continue;
            }
            stack.push(sarr[index]);
        }
        return stack.isEmpty();
    }
}