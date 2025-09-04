class Solution {
    public long solution(int w, int h) {
        long lw = w;
        long lh = h;
        long gcd = getGCD(lw, lh) ;
        return (lw * lh) - (lw + lh - gcd);
    }
    
    private long getGCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
}