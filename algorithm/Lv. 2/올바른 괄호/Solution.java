class Solution {
    boolean solution(String s) {
        int count = 0;
        for(String bracket : s.split("")) {
            if(bracket.equals("(")) count++;
            else count--;
            if(count < 0) break;
        }
        return count==0;
    }
}