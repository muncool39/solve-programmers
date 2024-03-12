class Solution {
    public int solution(int n) {
        int[] sum = new int[n+1];
        for(int i=1;i<=n;i++) {
            sum[i] = sum[i-1] + i;
        }
        int answer = 0, front = 0, back = 1;
        while(front < back) {
            int s = sum[back] - sum[front];
            if(s > n) front++;
            else back++;
            if(s == n) answer++;
            if(back > n) break;
        }
        return answer;
    } 
}