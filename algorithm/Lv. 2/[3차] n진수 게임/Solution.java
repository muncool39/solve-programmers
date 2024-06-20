class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder("");
        int number = 0, turn = 0;
        while(t>0) {
            String b_num = Integer.toString(number, n);
            for(String num : b_num.split("")) {
                if(t==0) break;
                turn++;
                if(turn > m) turn = 1;
                if(turn == p) {
                    sb.append(num);
                    t--;
                }
            }
            number++;
        }
        return sb.toString().toUpperCase();
    }
}