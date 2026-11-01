import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] crewTimes = new int[timetable.length];
        
        for(int i = 0; i < crewTimes.length; i++){
            crewTimes[i] = convertTimeToInt(timetable[i].split(":"));
        }
        
        Arrays.sort(crewTimes);
        
        int[] busGo = new int[n];
        int start = convertTimeToInt(new String[]{"09", "00"});
        for (int i = 0; i < n; i++) {
            busGo[i] = start;
            start += t; 
        }

        int crewIdx = 0;
        int answer = 0;
        for(int i = 0; i < n; i++) {
            int count = 0;
            while(crewIdx < crewTimes.length && count < m) { 
                if(busGo[i] >= crewTimes[crewIdx]) {
                    count++;
                    crewIdx++;
                } else {
                    break;
                }
            }
            
            if(count < m) {
                answer = busGo[i];
            } else if(count == m) {
                answer = crewTimes[crewIdx-1] - 1;
            }
        }
        
        return convertTimeToString(answer);
    }
    
    private int convertTimeToInt(String[] time) {
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }

    private String convertTimeToString(int time) {
        String hours = Integer.toString(time/60);
        String minutes = Integer.toString(time%60);
        
        hours = hours.length() < 2 ? "0"+hours : hours;
        minutes = minutes.length() < 2 ? "0"+minutes : minutes;
        
        return hours+":"+minutes;
    }
}
