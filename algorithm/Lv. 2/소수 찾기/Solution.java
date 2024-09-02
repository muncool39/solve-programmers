class Solution {
    boolean[] notsosu;
    boolean[] counted;
    int[] nums;
    boolean[] use;
    int size;
    public int solution(String numbers) {
        size = numbers.length();
        use = new boolean[size];
        nums = new int[size];
        
        int max = (int)Math.pow(10, size);
        notsosu = new boolean[max];
        counted = new boolean[max];
        notsosucheck(max);
        
        String[] n = numbers.split("");
        for(int i=0;i<size;i++) {
            nums[i] = Integer.parseInt(n[i]);
        }
        
        check(0, 0);
        return count;
    }
    
    int count = 0;
    public void check(int number, int deep) {
        if(!notsosu[number]&&!counted[number]) {
            count++;
            counted[number] = true;
        }
        if(deep > size) return;
        for(int i=0;i<size;i++) {
            if(use[i]) continue;
            if(deep==0&&nums[i]==0) continue;
            use[i] = true;
            check(number*10+nums[i], deep+1);
            use[i] = false;
        }
    }
    
    private void notsosucheck(int max) {
        notsosu[0] = true;
        notsosu[1] = true;
        for(int i=2;i<max;i++) {
            if(notsosu[i]) continue;
            for(int j=i+i;j<max;j+=i) {
                notsosu[j] = true;
            }
        }
    }
}