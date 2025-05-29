
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        boolean[] used = new boolean[n + 1];
        long[] factorial = new long[n + 1];

        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        k--; 

        for (int i = 0; i < n; i++) {
            long fact = factorial[n - 1 - i];
            for (int j = 1; j <= n; j++) {
                if (used[j]) continue;

                if (k >= fact) {
                    k -= fact;
                } else {
                    answer[i] = j;
                    used[j] = true;
                    break;
                }
            }
        }

        return answer;
    }
}
