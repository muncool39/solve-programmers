import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> friendsNumber = new HashMap<>(friends.length);
        for(int i=0;i<friends.length;i++) {
            friendsNumber.put(friends[i], i);
        }
        int[][] giveRecord = new int[friends.length][friends.length];
        int[] giftIndex = new int[friends.length];
        for(String giftDetails : gifts) {
            String[] users = giftDetails.split(" ");
            int giveUserId = friendsNumber.get(users[0]);
            int getUserId = friendsNumber.get(users[1]);
            giveRecord[giveUserId][getUserId]++;
            giftIndex[giveUserId]++;
            giftIndex[getUserId]--;
        }
        int max = 0;
        int[] nextTotal = new int[friends.length];
        for(int me=0;me<giveRecord.length;me++) {
            for(int friend=me;friend<giveRecord.length;friend++) {
                if(giveRecord[me][friend] > giveRecord[friend][me]) nextTotal[me]++;
                else if(giveRecord[me][friend] < giveRecord[friend][me]) nextTotal[friend]++;
                else {
                    if(giftIndex[me] > giftIndex[friend]) nextTotal[me]++;
                    else if(giftIndex[me] < giftIndex[friend]) nextTotal[friend]++;
                }
            }
            max = Math.max(nextTotal[me], max);
        }
        return max;
    }
}