class Solution{
    public int solution(int n, int a, int b){
        int round = 0;
        while(a!=b) {
            a -= a/2;
            b -= b/2;
            round++;
        }
        return round;
    }
}