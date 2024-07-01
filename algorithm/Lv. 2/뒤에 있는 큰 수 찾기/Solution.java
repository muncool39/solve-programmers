import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<numbers.length;i++) {
            if(stack.size()>0) { 
                int[] before = stack.peek();
                while(before[1] < numbers[i]) {
                    answer[before[0]] = numbers[i];
                    stack.pop();
                    if(stack.isEmpty()) break;
                    before = stack.peek();
                }
            }
            stack.add(new int[]{i, numbers[i]});
        }
        while(stack.size()>0) {
            int num = stack.pop()[0];
            answer[num] = -1;
        }
        return answer;
    }
}