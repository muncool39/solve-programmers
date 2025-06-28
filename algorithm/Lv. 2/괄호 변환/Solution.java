import java.util.*;

class Solution {
    
    HashMap<String, String> map = new HashMap<>(){{
        put("(", ")");
        put(")", "(");
    }};
    
    public String solution(String p) {
        return getStr(p);
    }
    
    private String getStr(String str) {
        if(str == "" || isRight(str)) {
            return str;
        } 
        int cri = getCri(str);
        String u = str.substring(0, cri);
        String v = str.substring(cri, str.length());
        if(isRight(u)) {
            return u + getStr(v);
        }
        return "(" + getStr(v) + ")" + changeU(u); 
    }
    
    private String changeU(String u) {
        if (u.length() <= 2) {
            return "";
        }
        u = u.substring(1, u.length()-1);
        StringBuilder sb = new StringBuilder();
        for(String s : u.split("")) {
            sb.append(map.get(s));
        }
        return sb.toString();
    }
    
    private int getCri(String str) {
        int r = 0;
        int l = 0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) == '(') r++;
            else l++;
            if(r==l) {
                return i+1;
            }
        }
        return 0;
    }
    
    private boolean isRight(String str) {   
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++) {
            char now = str.charAt(i);
            if(stack.size()>0 && now == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(now);
            }
        }
        return stack.isEmpty();
    }
}