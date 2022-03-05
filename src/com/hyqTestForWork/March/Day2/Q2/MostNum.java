package com.hyqTestForWork.March.Day2.Q2;
/**
 *@Author \
 *@Description TODO 剑指 Offer 39. 数组中出现次数超过一半的数字 medium
 *@Date 2022/3/2 19:04
 *@Param
 *@return
 *@Version
 **/
public class MostNum {
    public int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==candidate){
                count++;
                continue;
            }

            if(count==0){
                candidate = nums[i];
                count+=1;
                continue;
            }

            if(count>0){
                count-=1;
            }

        }


        return candidate;
    }
}
