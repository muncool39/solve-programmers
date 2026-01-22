class Solution {
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int start = getStart(deliveries, pickups, n);
        while(start >= 0) {
            answer+=((start+1)*2);
            start = Math.max(go(start, cap, deliveries), go(start, cap, pickups));
        }
        return answer;
    }
    
    private int go(int start, int cap, int[] arr) {
        for(int i=start;i>=0;i--) {
            if(arr[i] == 0) {
                continue;
            }
            int a = arr[i];
            if(a <= cap) {
                arr[i] = 0;
                cap -= a;
                continue;
            }
            arr[i]-=cap;
            return i;
        }
        return -1;
    }
    
    private int getStart(int[] a1, int[] a2, int n) {
        for(int i=n-1;i>=0;i--) {
            if(a1[i] > 0 || a2[i] > 0) {
                return i;
            }
        }
        return -1;
    }
    
}