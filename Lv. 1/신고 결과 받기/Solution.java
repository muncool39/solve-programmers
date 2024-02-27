import java.util.*;
class Solution {
    HashSet[] reportList;
    HashMap<String, Integer> userMap;
    public int[] solution(String[] id_list, String[] report, int k) {
        setUserMap(id_list);
        setReportList(id_list);

        for(String reportDetails : report) {
            String[] reportIds = reportDetails.split(" ");
            int sentId = userMap.get(reportIds[0]);
            int receivedId = userMap.get(reportIds[1]);
            reportList[receivedId].add(sentId);
        }
        
        int[] result = new int[id_list.length];
        for(HashSet reportSet : reportList) {
            if(reportSet.size() < k) continue;
            Iterator iterator = reportSet.iterator();
            while(iterator.hasNext()) {
                result[(int)iterator.next()]++;
            }
        }
        return result;
    }
    
    private void setUserMap(String[] id_list) {
        userMap = new HashMap<>(id_list.length);
        for(int i=0;i<id_list.length;i++) {
            userMap.put(id_list[i], i);
        }
    }
    private void setReportList(String[] id_list) {
        reportList = new HashSet[id_list.length];
        for(int i=0;i<id_list.length;i++) {
            reportList[i] = new HashSet<Integer>();
        }
    }
}