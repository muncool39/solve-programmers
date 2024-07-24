import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> belt = new Stack<>();
        int answer = 0;
        int index = 0; int number = 1;
        while(index<order.length && number<=order.length) {
            if(order[index]!=number) {
                belt.add(number);
            } else {
                answer++;
                index++;
                while(belt.size()>0 && index<order.length) {
                    if(belt.peek() < order[index]) break;
                    if(belt.peek() != order[index]) break;
                    answer++;
                    belt.pop();
                    index++;
                }
            }
            number++;
        }
        return answer;
    }
}