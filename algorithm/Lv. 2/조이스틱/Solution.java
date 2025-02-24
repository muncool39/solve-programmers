class Solution {
    public int solution(String name) {
        int size = name.length();
        int change = 0;
        int move = size - 1;
        for(int i=0;i<size;i++) {
            change+= Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            int next = i + 1;
            if(next < size && name.charAt(next) == 'A') {
                while(next < size && name.charAt(next) == 'A') {
                    next++;
                }
                move = Math.min(move, Math.min(i*2+size-next, (size-next)*2+i));
            }
        }
        return change + move;
    }
}