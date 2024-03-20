class Solution {
    public int[] solution(String s) {
        int zeroCount = 0, timeCount = 0;
        while (s.length() > 1) {
            zeroCount += s.length() - s.replace("0", "").length();
            int c = s.replace("0", "").length();
            s =  Integer.toBinaryString(c);
            timeCount++;
        }
        int[] answer = {timeCount, zeroCount};
        return answer;
    }
}