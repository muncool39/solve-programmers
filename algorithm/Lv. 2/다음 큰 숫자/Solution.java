class Solution {
    public int solution(int n) {
        String binaryN = Integer.toBinaryString(n);
        int oneLength = binaryN.length() - binaryN.replace("1", "").length();
        int nextNumber = n + 1;
        while(true) {
            String binaryNext = Integer.toBinaryString(nextNumber);
            int nextLength = binaryNext.length() - binaryNext.replace("1", "").length();
            if(oneLength == nextLength) return nextNumber;
            nextNumber++;
        }
    }
}