import java.util.regex.Pattern;
import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        String a = str1.toUpperCase();
        String b = str2.toUpperCase();
        ArrayList<String> alist = makeList(a.split(""));
        ArrayList<String> blist = makeList(b.split(""));
        
        if(alist.size() == 0 && blist.size() == 0) {
            return 65536;
        }
        
        int A = getAnBCount(alist, blist);
        ArrayList<String> AuB = new ArrayList<>(alist);
        AuB.addAll(blist);
        int B = AuB.size() - A;
        
        return (int) (A/(double)B * 65536);
        
    }
    
    private int getAnBCount(ArrayList<String> a, ArrayList<String> b) {
        HashMap<String, Integer> aMap = new HashMap<>();
        HashMap<String, Integer> nMap = new HashMap<>();
        for(String str : a) {
            aMap.put(str, aMap.getOrDefault(str, 0) + 1);
        }
        for(String str : b) {
            if(aMap.containsKey(str)) {
                nMap.put(str, nMap.getOrDefault(str, 0) + 1);
            }
        }
        int nCount = 0;
        for(String key : nMap.keySet()) {
            nCount += Math.min(aMap.get(key), nMap.get(key));
        }
        return nCount;
    }
    
    String REGEXP_ONLY_ENG = "^[A-Z]*$";
    
    private ArrayList<String> makeList(String[] str) {
        ArrayList<String> list = new ArrayList<>();
        for(int i=1;i<str.length;i++) {
            String join = str[i-1]+str[i];
            if(!Pattern.matches(REGEXP_ONLY_ENG, join)) {
                continue;
            }
            list.add(join);
        }
        return list;
    }
}