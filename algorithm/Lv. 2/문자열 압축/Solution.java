import java.util.*;
class Solution {
    public int solution(String s) {
        int size = s.length();
        int maxCut = size/2;
        int result = size;
        for(int c=1;c<=maxCut;c++) {
            Stack<String> stack = new Stack<>();
            stack.add(s.substring(0, c));
            
            int comCount = 1;
            int plusLeng = 0;
            int tail = 0;
            
            for(int i=c;i<size;i+=c) {
                if(i + c > size) {
                    tail = size - i;
                    break;
                }
                String cs = s.substring(i, i + c);
                if(stack.peek().equals(cs)) {
                    comCount++;
                    continue;
                } else {
                    stack.add(cs);
                    if(comCount > 1) {
                        plusLeng += String.valueOf(comCount).length();
                    }
                    comCount = 1;
                }
            }
            if(comCount > 1) {
                plusLeng += String.valueOf(comCount).length();
            }
            int lg = stack.size() * c + tail + plusLeng;
            if(result > lg) {
                result = lg;
            }
        }
        return result;
    }
}