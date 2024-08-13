import java.util.*;

class Solution {
    HashMap<String, String> user = new HashMap<>();
    HashMap<String, String> message = new HashMap<>(){{
        put("Enter", "님이 들어왔습니다.");
        put("Leave", "님이 나갔습니다.");
    }};
    public String[] solution(String[] record) {
        ArrayList<String> chat = new ArrayList<>();
        for(String log : record) {
            String[] details = log.split(" ");
            String command = details[0];
            if(command.equals("Change")) {
                user.replace(details[1], details[2]);
                continue;
            }
            if(command.equals("Enter")) {
                user.put(details[1], details[2]);
            }
            chat.add(details[1]);
            chat.add(message.get(command));
        }
        String[] answer = new String[chat.size()/2];
        int index = 0;
        for(int i=0;i<chat.size();i+=2) {
            answer[index] = user.get(chat.get(i)) + chat.get(i+1);
            index++;
        }
        return answer;
    }
}