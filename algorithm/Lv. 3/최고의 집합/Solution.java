class Solution {
    public int[] solution(int n, int s) {
        if(n > s) {
            return new int[]{-1};
        }
        int m = s/n;
        int r = s%n;
        
        int[] answer = new int[n];
        for(int i=n-1;i>=0;i--) {
            answer[i]+=m;
            if(r > 0) {
                answer[i]++;
                r--;
            }
        }
        return answer;
    }
}