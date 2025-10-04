import java.util.*;

class Solution {
    int bidSize;
    ArrayList<String>[] bList;
    ArrayList<HashSet<String>> setList = new ArrayList<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        bidSize = banned_id.length;
        bList = new ArrayList[bidSize];
        init();
        for(int i=0;i<bidSize;i++) {
            String bid = banned_id[i];
            int len = bid.length();
            ArrayList<Integer> checkIdx = getIdxList(bid, len);
            for(String uid : user_id) {
                if(uid.length() != len) {
                    continue;
                }
                int sameCount = 0;
                for(int idx : checkIdx) {
                    if(uid.charAt(idx) != bid.charAt(idx)) {
                        break;
                    }
                    sameCount++;
                }
                if(sameCount == checkIdx.size()) {
                    bList[i].add(uid);
                }
            }
        }
        combination(new HashSet<>(), 0);
        return setList.size();
    }
    
    private void combination(HashSet<String> set, int index) {
        if(index == bidSize) {
            for(HashSet<String> hs : setList) {
                if(hs.equals(set)) {
                    return;
                }
            }
            HashSet<String> nset = new HashSet<>();
            for(String s : set) {
                nset.add(s);
            }
            setList.add(nset);
            return;
        }
        for(String id : bList[index]) {
            if(set.contains(id)) {
                continue;
            }
            set.add(id);
            combination(set, index + 1);
            set.remove(id);
        }
    }
    
    private void init() {
        for(int i=0;i<bidSize;i++) {
            bList[i] = new ArrayList<>();
        }
    }
    
    private ArrayList<Integer> getIdxList(String bid, int len) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<len;i++) {
            if(bid.charAt(i) == '*') {
                continue;
            }
            list.add(i);
        }
        return list;
    }
}

