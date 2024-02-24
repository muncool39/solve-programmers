import java.util.*;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.time.LocalDate;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, formatter);
        
        HashMap<String, Integer> termMap = new HashMap<>();
        for(int i=0;i<terms.length;i++) {
            String[] term = terms[i].split(" ");
            termMap.put(term[0], Integer.parseInt(term[1]));
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<privacies.length;i++) {
            String[] privacy = privacies[i].split(" ");
            int term = termMap.get(privacy[1]);
            LocalDate ValidityDate = LocalDate.parse(privacy[0], formatter).plusMonths(term);
            if(ValidityDate.isAfter(todayDate)) continue;
            result.add(i+1);
        }
        
        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
    
}