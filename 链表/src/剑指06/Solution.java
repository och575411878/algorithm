package 剑指06;

public class Solution {
    public int[] reversePrint(ListNode head) {
        if(head==null)return new int[0];
        int[] pre = reversePrint(head.next);
        int[] ans = new int[pre.length+1];
        System.arraycopy(pre, 0, ans, 0, pre.length);
        ans[pre.length] = head.val;
        return ans;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}