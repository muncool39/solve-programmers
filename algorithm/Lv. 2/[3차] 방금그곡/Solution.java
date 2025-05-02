import java.util.*;

class Solution {
    
    HashMap<String, String> noteMap = new HashMap<>(){{
        put("C#","1");
        put("D#","2");
        put("F#","3");
        put("G#","4");
        put("A#","5");
    }};
    
    public String solution(String m, String[] musicinfos) {
        String note = convertNote(m);
        int maxTime = 0;
        String matchName = "";
        for(String musicinfo : musicinfos) {
            String[] infos = musicinfo.split(",");
            int playTime = getPlaytime(infos[0], infos[1]);
            String totalMusic = cutting(playTime, convertNote(infos[3]));
            if(isMatch(note, totalMusic) && (playTime > maxTime)) {
                matchName = infos[2];
                maxTime = playTime;
            }
        }
        return (matchName.length() > 0) ? matchName : "(None)";
    }
    
    private boolean isMatch(String standard, String target){
        return (target.length() == target.replace(standard, "").length())
            ? false
            : true;
    }
    
    private String cutting(int playTime, String music) {
        int m_length = music.length();
        if(playTime < m_length) {
            return music.substring(0, playTime);
        }
        int repe = playTime / m_length;
        int plus = playTime % m_length;
        StringBuilder sb = new StringBuilder(music);
        for(int i=0;i<repe;i++) {
            sb.append(music);
        }
        sb.append(music.substring(0, plus));
        return sb.toString();
    }
    
    private String convertNote(String mNote) {
        for(String n : noteMap.keySet()) {
            mNote = mNote.replace(n, noteMap.get(n));
        }
        return mNote;
    }
    
    private int getPlaytime(String start, String end) {
        return convertStringToTime(end) - convertStringToTime(start);
    }
    
    private int convertStringToTime(String str) {
        String[] time = str.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}