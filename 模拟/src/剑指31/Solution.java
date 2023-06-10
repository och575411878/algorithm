package 剑指31;

import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i =0;
        int pop_p =0;
        while(i<pushed.length){
            stack.push(pushed[i++]);
            while(stack.size()!=0&&pop_p<popped.length&&stack.peek()==popped[pop_p]){
                stack.pop();
                pop_p++;
            }
        }
        return stack.size()==0;
    }
}