class Solution {
    public long[] solution(long[] nums) {
        long[] ans = new long[nums.length];
        int idx=0;
        for(long num:nums) {
            for(long i=1;;i<<=1) {
                if((num&i)==0) {
                    num|=i;
                    num^=(i>>1);
                    break;
                }
            }
            ans[idx++]=num;
        }
        return ans;
    }
}