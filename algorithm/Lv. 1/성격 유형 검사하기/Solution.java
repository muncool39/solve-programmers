import java.util.*;
class Solution {
    HashMap<String, Integer> TypeMap = new HashMap<>();
    public String solution(String[] survey, int[] choices) {
        String[][] TypeIndex = {{"R","T"},{"C","F"},{"J","M"},{"A","N"}};
        for(int i=0;i<survey.length;i++) {
            int score = choices[i];
            if(score < 4) scoreUp(survey[i].split("")[0], score);
            else if (score > 4) scoreUp(survey[i].split("")[1], score);
        }
        StringBuilder answer = new StringBuilder("");
        for(int i=0;i<TypeIndex.length;i++) {
            answer.append(getPersonalityType(TypeIndex[i][0], TypeIndex[i][1]));
        }
        return answer.toString();
    }
    
    private void scoreUp(String keyType, int score) {
        int finalScore = Math.abs(score - 4);
        TypeMap.put(keyType, TypeMap.getOrDefault(keyType, 0) + finalScore);
    }
    private String getPersonalityType (String firstType, String secondType) {
        int firstTypeScore = TypeMap.getOrDefault(firstType, 0);
        int secondTypeScore = TypeMap.getOrDefault(secondType, 0);
        
        if(firstTypeScore > secondTypeScore) return firstType;
        if(firstTypeScore < secondTypeScore) return secondType;
        if(firstType.compareTo(secondType) < 0) return firstType;
        return secondType;
    }
}