import java.util.*;
class Solution{
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++) {
            char munza = s.charAt(i);
            if(stack.isEmpty() || stack.peek()!=munza) {
                stack.push(munza);
                continue;
            }
            stack.pop();
        }
        return (stack.isEmpty())?1:0;
    }
}