class Solution {
    public int[] solution(int n, int m) {
        int gcd = getGCD(n, m);
        return new int[]{gcd, ((n*m)/gcd)};
    }
    
    private int getGCD(int n1, int n2) {
        if(n1 % n2 == 0) {
            return n2;
        }
        return getGCD(n2, n1%n2);
    }
}