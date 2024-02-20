import java.util.*;
class Solution {
    int count = 0;
    int[][] board;
    Stack<Integer> stack = new Stack<>();
    public int solution(int[][] boardInput, int[] moves) {
        board = boardInput;
        for(int m : moves) {
            int line = getDollLine(m-1);
            if(line < 0) continue;
            int doll = board[line][m-1];
            board[line][m-1] = 0;
            pushDoll(doll);
        }
        return count;
    }
    private int getDollLine(int m) {
        for(int i=0;i<board.length;i++) {
            if(board[i][m]==0) continue;
            return i;
        }
        return -1;
    }
    
    private void pushDoll(int doll) {
        if(stack.isEmpty()) {
            stack.push(doll);
            return;
        }
        if(stack.peek()==doll) {
            stack.pop();
            count+=2;
            return;
        }
        stack.push(doll);
    }
}