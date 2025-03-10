import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int size = words.length;
        int t_index = -1;
        for(int i=0;i<size;i++) {
            if(words[i].equals(target)) {
                t_index = i;
                break;
            }
        }
        if(t_index == -1) return 0;

        return getCount(begin, t_index, words, size);
    }
    
    private int getCount(String begin, int t_index, String[] words, int size) {
        int[] count = new int[size];
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<size;i++) {
            if(isPossibleConvert(begin, words[i])) {
                que.add(i);
                count[i]++;
            }
        }
        while(que.size()>0 && count[t_index]==0) {
            int now = que.poll();
            for(int i=0;i<size;i++) {
                if(count[i]==0 && isPossibleConvert(words[now], words[i])) {
                    que.add(i);
                    count[i]+=(count[now]+1);
                }
            }
        }
        return count[t_index];
    }
    
    private boolean isPossibleConvert(String b, String t) {
        int diff = 0;
        for(int i=0;i<b.length();i++) {
            if(b.charAt(i) != t.charAt(i)) diff++;
        }
        return (diff==1) ? true : false;
    }
}
