import java.util.*;

class Solution {

    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int ans = 0;
        int max = Math.max(arrayA[0], arrayB[0]);
        for(int num=max;num>1;num--) {
            if((isSub(num, arrayA) && isNotSub(num, arrayB)) || 
               (isSub(num, arrayB) && isNotSub(num, arrayA))) {
                ans = num;
                break;
            }
        }
        return ans;
    }
    
    public boolean isSub(int number, int[] array) {
        for(int t : array) {
            if(t%number!=0) return false;
        }
        return true;
    }
    
    public boolean isNotSub(int number, int[] array) {
        for(int t : array) {
            if(t%number==0) return false;
        }
        return true;
    }
    
}