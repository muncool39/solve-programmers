class Solution {
    int[] XCount = new int[10];
    int[] YCount = new int[10];
    int[] partnerCount = new int[10];
    StringBuilder partner = new StringBuilder("");
    public String solution(String X, String Y) {
        doXCount(X.split(""));
        doYCount(Y.split(""));
        doPartnerCount();
        String answer = getPartnerNumbers();
        return answer;
    }
    private void doXCount(String[] XArray) {
        for(String x : XArray){
            int index = Integer.parseInt(x);
            XCount[index]++;
        }
    }
    private void doYCount(String[] YArray) {
        for(String y : YArray){
            int index = Integer.parseInt(y);
            YCount[index]++;
        }
    }
    private void doPartnerCount() {
        for(int i=0;i<partnerCount.length;i++){
            partnerCount[i] = Math.min(XCount[i], YCount[i]);
        }
    }
    private String getPartnerNumbers() {
        for(int i=9;i>=0;i--){
            doAddPartnerNumber(i);
        }
        String p = partner.toString();
        if(p.length()==0) return "-1";
        if(p.replace("0","").length()==0) return "0";
        return p;
    }
    private void doAddPartnerNumber(int partnerNumber) {
        for(int i=0;i<partnerCount[partnerNumber];i++){
            partner.append(partnerNumber);
        }
    }
}