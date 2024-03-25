class Solution {
    public int[] solution(int brown, int yellow) {
        for(int i=6;i<brown;i+=2) {
            int top = i/2;
            int side = ((brown-i)/2)+2;
            int middle = (top-2)*(side-2);
            if(middle == yellow) {
                return new int[]{side, top};
            }
        }
        return new int[]{0, 0};
    }
}