class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder("");
        while(n > 0) {
            int a = n % 3;
            int b = n / 3;
            if(a == 0) {
                b -= 1;
                a = 4;
            }
            n = b;
            sb.append(a);
        }
        return sb.reverse().toString();
    }
}