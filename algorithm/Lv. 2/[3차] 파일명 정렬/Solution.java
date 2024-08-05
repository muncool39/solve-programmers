import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (s1, s2) -> {
            String h1 = s1.split("[0-9]")[0].toUpperCase();
            String h2 = s2.split("[0-9]")[0].toUpperCase();
            if(h1.equals(h2)) {
                s1 = s1.substring(h1.length(), s1.length());
                s2 = s2.substring(h2.length(), s2.length());
                int n1 = Integer.parseInt(s1.split("[^0-9]")[0]);
                int n2 = Integer.parseInt(s2.split("[^0-9]")[0]);
                return n1 - n2;
            }
            return h1.compareTo(h2);
        });
        return files;
    }
}