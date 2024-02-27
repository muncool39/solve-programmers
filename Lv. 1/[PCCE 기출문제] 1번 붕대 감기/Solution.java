class Solution {
    int exTime, recovery, plusRecovery, maxHealth;
    public int solution(int[] bandage, int health, int[][] attacks) {
        setSkill(bandage);
        maxHealth = health;
        health-=attacks[0][1];
        if(health <= 0) return -1;
        for(int i=1;i<attacks.length;i++) {
            int second = attacks[i][0] - attacks[i-1][0];
            health = getRecoverHealth(health, second-1);
            health-=attacks[i][1];
            if(health <= 0) return -1;
        }
        return health;
    }
    private void setSkill(int[] bandage) {
        exTime = bandage[0];
        recovery = bandage[1];
        plusRecovery = bandage[2];
    }
    private int getRecoverHealth(int health, int second) {
        int recoverHealth = health+(second*recovery)+((second/exTime)*plusRecovery);
        return Math.min(recoverHealth, maxHealth);
    }
}