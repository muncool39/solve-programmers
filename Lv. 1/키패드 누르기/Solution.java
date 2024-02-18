import java.util.*;
class Solution {
    HashMap<Integer, String> keyPad = new HashMap<>() {{
        put(1, "L");
        put(4, "L");
        put(7, "L");
        put(3, "R");
        put(6, "R");
        put(9, "R");
    }};
    HashMap<Integer, int[]> coordinates = new HashMap<>() {{
        put(1, new int[]{-1,3});
        put(2, new int[]{0,3});
        put(3, new int[]{1,3});
        put(4, new int[]{-1,2});
        put(5, new int[]{0,2});
        put(6, new int[]{1,2});
        put(7, new int[]{-1,1});
        put(8, new int[]{0,1});
        put(9, new int[]{1,1});
        put(0, new int[]{0,0});
    }};
    int[] leftPosition = {-1,0};
    int[] rightPosition = {1,0};
    public String solution(int[] numbers, String hand) {
        String defaultPosition = getHandDefaultPosition(hand);
        StringBuilder answer = new StringBuilder("");
        for(int number : numbers) {
            String handPosition = keyPad.getOrDefault(number, "?");
            if(handPosition.equals("?")) handPosition = getHandPosition(number, defaultPosition);
            if(handPosition.equals("L")) leftPosition = coordinates.get(number);
            else if(handPosition.equals("R")) rightPosition = coordinates.get(number);
            answer.append(handPosition);
        }
        return answer.toString();
    }
    
    private String getHandPosition(int number, String defaultPosition) {
        double LDistance = getDistance(leftPosition, coordinates.get(number));
        double RDistance = getDistance(rightPosition, coordinates.get(number));
        if(LDistance < RDistance) return "L";
        if(LDistance > RDistance) return "R";
        return defaultPosition;
    }
    
    private double getDistance(int[] now, int[] target){
        return Math.abs(target[0]-now[0]) + Math.abs(target[1]-now[1]);
    }
    
    private String getHandDefaultPosition(String hand) {
        if(hand.equals("left")) return "L";
        return "R";
    }
}
