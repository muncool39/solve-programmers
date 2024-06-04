class Solution {
    public int solution(int n, int k) {
        String[] numarr = Integer.toString(n, k).split("0");
        int count = 0;
        for(String obj : numarr) {
            if(obj.equals("")) continue;
            long number = Long.parseLong(obj);
            if(isSosu(number)) count++;
        }
        return count;
    }
    private boolean isSosu(long number) {
        if(number==1) return false;
        long max = (long)Math.sqrt(number);
        for(long i=2;i<=max;i++) {
            if(number%i==0) return false;
        }
        return true;
    }
}