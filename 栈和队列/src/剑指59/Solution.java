package 剑指59;

import java.util.*;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int left = 0, right = 0;
        for (int i = 0; i < k; i++) {
            while (deque.size() != 0 && deque.peekLast() < nums[right]) {
                deque.removeLast();
            }
            deque.addLast(nums[right++]);
        }
        ans.add(deque.peekFirst());
        while (right < nums.length) {
            if (nums[left++] == deque.peekFirst()) {
                deque.removeFirst();
            }
            while (deque.size() != 0 && deque.peekLast() < nums[right]) {
                deque.removeLast();
            }
            deque.addLast(nums[right++]);
            ans.add(deque.peekFirst());
        }
        int[] ans_array = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ans_array[i] = ans.get(i);
        }
        return ans_array;
    }
}
