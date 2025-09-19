class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int i=0;i<=d;i+=k) {
            answer++;
            answer+=(getMaxY(i, d)/k);
        }
        return answer;
    }
    
    private int getMaxY(int x, int d) {
        long px = (long) Math.pow(x, 2);
        long pd = (long) Math.pow(d, 2);
        return (int) Math.sqrt(pd - px);
    }
}