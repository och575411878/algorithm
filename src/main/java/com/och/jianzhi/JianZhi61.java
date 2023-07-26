package com.och.jianzhi;

import java.util.Arrays;

public class JianZhi61 {
    public boolean isStraight(int[] nums) {
        int pre = 0;
        int count = 0;
        Arrays.sort(nums,0,nums.length);
        for(int i = 0;i< nums.length;i++){
            if(nums[i]==0){
                count++;
            }else{
                if(pre == 0){
                    pre = nums[i];
                }else if(pre!=0){
                    int del = nums[i] - pre-1;
                    if(del>count||del==-1){
                        return false;
                    }else{
                        count -=del;
                        pre = nums[i];
                    }
                }
            }
        }
        return true;
    }
}
