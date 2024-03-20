class Solution {
    public String solution(String s) {
        String[] sarr = s.toLowerCase().split("");
        for(int i=0;i<sarr.length;i++) {
            if(sarr[i].equals(" ")) continue;
            sarr[i] = sarr[i].toUpperCase();
            while(i<sarr.length-1 && !sarr[++i].equals(" ")){};
        }
        return String.join("", sarr);
    }
}