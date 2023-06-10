package 剑指58;

public class Solution {
    // 双指针类似窗口边界控制.
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int right_p = s.length() - 1;
        int left_p = s.length() - 1;
        while(left_p >= 0){
            while(left_p >= 0 && s.charAt(left_p) != ' '){
                left_p -- ;
            }
            sb.append(s.substring(left_p+1,right_p+1)+" ");
            while(left_p >=0 && s.charAt(left_p) == ' '){
                left_p -- ;
            }
            right_p = left_p;
        }
        return sb.toString().trim();
    }
}
