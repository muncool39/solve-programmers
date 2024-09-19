class Solution {
    int max; int ops; int ope;
    public String solution(String video_len, String pos, 
                           String op_start, String op_end, String[] commands) {
        max = convertToInt(video_len);
        ops = convertToInt(op_start); ope = convertToInt(op_end);
        int now = opjump(convertToInt(pos));
        for(String c : commands) {
            now = opjump((c.equals("prev"))?prev(now):next(now));
        }
        return convertToString(now);
    }

    public int prev(int now) {
        if(now<10) return 0;
        return now-=10;
    }
    
    public int next(int now) {
        if(now+10>=max) return max;
        return now+=10;
    }
    
    public int opjump(int now) {
        if(ops<=now && now<=ope) return ope;
        return now;
    }
    
    public int convertToInt(String s) {
        String[] input = s.split(":");
        return Integer.parseInt(input[0])*60 + Integer.parseInt(input[1]);
    }
    
    public String convertToString(int now) {
        StringBuilder sb = new StringBuilder("");
        int m = now/60;
        int s = now%60;
        if(m<10) sb.append("0");
        sb.append(m).append(":");
        if(s<10) sb.append("0");
        sb.append(s);
        return sb.toString();
    }
    
}