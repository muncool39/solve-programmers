class Solution {
    String[] skillSeq;
    public int solution(String skill, String[] skill_trees) {
        skillSeq = skill.split("");
        int answer = 0;
        for(String tree : skill_trees){
            if(isPossible(tree)) answer++;
        }
        return answer;
    }
    public boolean isPossible(String tree) {
        int loc = -1;
        boolean end = false;
        for(String skill : skillSeq) {
            int now = tree.indexOf(skill);
            if(end && now > -1) return false;
            if(now==-1) end = true;
            else if(loc > now) return false;
            loc = now;
        }
        return true;
    }
}