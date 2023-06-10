package 剑指57;

public class Solution {
    // 通过指针移动的状态消去证明 听有意思的
    public int[] twoSum(int[] nums, int target) {
        int left_p = 0;
        int right_p = nums.length - 1;
        int[] ans = new int[2];
        while(left_p<right_p){
            if(nums[left_p]+nums[right_p]>target){
                right_p--;
            }else if(nums[left_p]+nums[right_p]<target){
                left_p++;
            }else{
                ans[0]  = nums[left_p];
                ans[1] = nums[right_p];
                break;
            }
        }
        return ans;
    }
}
