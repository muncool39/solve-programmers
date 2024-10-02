class Solution {
    public int[] solution(int[] sequence, int k) {
        int max = sequence.length;
        long[] sum = new long[max+1];
        for(int i=1;i<=max;i++) {
            sum[i] = sum[i-1] + sequence[i-1];
        }
        int[] ans = new int[2];
        int front = 0, back = 1;
        int min = 1000001;
        while(back<=max) {
            long now = sum[back] - sum[front];
            if(now < k) {
                back++;
            } else if(now > k) {
                front++;
            } else {
                if((back-front) < min) {
                    min = back-front;
                    ans[0] = front;
                    ans[1] = back-1;
                }
                front++;
                back++;
            }
        }
        return ans;
    }
}