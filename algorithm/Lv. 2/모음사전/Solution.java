class Solution {
    public int count = 0;
    public String target;
    public boolean find = false;
    public char[] moum = { 'A', 'E', 'I', 'O', 'U' };
    public int solution(String word) {
        target = word;
        doWordCount("", 0);
        return count;
    }
    
    private void doWordCount(String frontMoum, int deep) {
        if(deep == 5) return;
        for(int i=0;i<5;i++) {
            if(find) break;
            count++;
            String nowMoum = frontMoum + moum[i];
            find = check(nowMoum);
            doWordCount(nowMoum, deep+1);
        }
    }
    
    private boolean check(String word) {
        if(word.equals(target)) return true;
        return false;
    }
}