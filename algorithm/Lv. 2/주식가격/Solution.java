import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<prices.length-1;i++) {
            if(stack.size()>0) {
               while(stack.peek()[1]>prices[i]) {
                    int index = stack.pop()[0];
                    answer[index] = i - index;
                    if(stack.isEmpty()) break;
                } 
            }
            stack.add(new int[]{i, prices[i]});
        }
        int last = prices.length - 1;
        while(stack.size()>0) {
            int index = stack.pop()[0];
            answer[index] = last - index;
        }
        return answer;
    }
}