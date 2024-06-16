import java.util.*;

class Solution {
    HashMap<String, Integer> dictionary = new HashMap<>();
    public int[] solution(String msg) {
        init();
        ArrayList<Integer> num = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<msg.length();i++) {
            sb.append(msg.charAt(i));
            if(!dictionary.containsKey(sb.toString())) {
                dictionary.put(sb.toString(), dictionary.size() + 1);
                sb.setLength(sb.length() - 1);
                num.add(dictionary.get(sb.toString()));
                sb.setLength(0);
                i--;
            }
        }
        if(sb.length() > 0){
            num.add(dictionary.get(sb.toString()));
        }
        int[] answer = new int[num.size()];
        for (int i = 0; i < num.size(); i++) {
            answer[i] = num.get(i);
        }
        return answer;
    }
    
    private void init() {
        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        for(int i=0;i<alphabet.length;i++) {
            dictionary.put(alphabet[i], i+1);
        }
    }
}