class Solution {
    public int solution(int n, int[] money) {
        int[] comb = new int[n+1];
        comb[0] = 1;
        for(int i = 0; i<money.length; i++) {
            for(int j = money[i]; j<=n; j++) {
                comb[j] += (comb[j - money[i]])%1000000007;
            }
        }
        return comb[n];
    }
}