class Solution {
    public long solution(int n) {
        long[] way = new long[n+2];
        way[1] = 1;
        way[2] = 2;
        for(int i=3;i<=n;i++) {
            way[i] = (way[i-1] + way[i-2]) % 1234567;
        }
        return way[n];
    }
}