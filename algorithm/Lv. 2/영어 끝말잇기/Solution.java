import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> wordSet = new HashSet<>();
        wordSet.add(words[0]);
        char last = words[0].charAt(words[0].length()-1);
        for(int i=1;i<words.length;i++) {
            String word = words[i];
            if(word.charAt(0)!=last || wordSet.contains(word)) {
                return new int[]{i % n + 1, i / n + 1};
            }
            last = word.charAt(words[i].length()-1);
            wordSet.add(word);
        }
        return new int[]{0,0};
    }
}