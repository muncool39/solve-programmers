class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0];
        for(int num : arr) {
            if(lcm % num == 0) continue;
            lcm = getLCM(lcm, num);
        }
        return lcm;
    }
    private static int getLCM(int num1, int num2) {
        return (num1*num2)/getGCD(num1, num2);
    }
    private static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) return num2;
        return getGCD(num2, num1%num2);
    }
}