import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int count = k;
        for (int i=0;i<number.length();i++) {
            char num = number.charAt(i);
            while (!stack.isEmpty() && count>0 && stack.peek()<num) {
                stack.pop();
                count--;
            }
            stack.push(num);
        }
        while(count > 0) {
            stack.pop();
            count--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    
}