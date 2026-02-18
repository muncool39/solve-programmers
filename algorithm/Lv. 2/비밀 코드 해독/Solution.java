import java.util.*;

class Solution {
    int answer = 0;
    HashSet<Integer>[] setList;
    
    public int solution(int n, int[][] q, int[] ans) {
        setList = new HashSet[q.length];
        for(int i=0;i<q.length;i++) {
            setList[i] = new HashSet<>();
            for(int num : q[i]) {
                setList[i].add(num);
            }
        }
        combine(n, 1, 0, new int[5], ans);
        return answer;
    }
    
    private void combine(int n, int start, int index, int[] nums, int[] ans) {
        if(index == 5) {
            if(isCode(nums, ans)) {
                answer++;
            }
            return;
        }
        for(int i=start;i<=n;i++) {
            nums[index] = i;
            combine(n, i+1, index+1, nums, ans);
        }
    }
    
    private boolean isCode(int[] nums, int[] ans) {
        for(int i=0;i<setList.length;i++) {
            HashSet<Integer> set = setList[i];
            int res = 0;
            for(int n : nums) {
                if(set.contains(n)) {
                    res++;
                }
            }
            if(res != ans[i]) {
                return false;
            }
        }
        return true;
    }
}
