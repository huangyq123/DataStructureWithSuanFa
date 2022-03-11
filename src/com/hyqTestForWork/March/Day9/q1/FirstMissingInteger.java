package com.hyqTestForWork.March.Day9.q1;

import org.junit.Test;

/**
 *@Author admin
 *@Description TODO  41. 缺失的第一个正数  hard
 *@Date 2022/3/9 15:59
 *@Param
 *@return
 *@Version
 **/
public class FirstMissingInteger {
    //看题解写的——总体思路：使用原数组进行原地标记（相当于一个哈希表），通过正负性进行是否存在的标记； 标记结束遍历查找第一个不存在的数；
    //细节： 需要先进行预处理，将负数进行处理；  进行标记时会产生负数，需要使用绝对值来进行存在性的判断并标记；  注意0的处理
    public int firstMissingPositive(int[] nums){

        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                nums[i]=nums.length+1;
            }
        }

        for(int i=0;i<nums.length;i++){
            int current = Math.abs(nums[i]);
            if(current>=1&&current<=nums.length){
                int temp = nums[current-1];
                if(temp>0){
                    nums[current-1]*=-1;
                }
                if(temp==0){
                    nums[current-1]=-(nums.length+1);
                }
            }
        }

        int result = nums.length+1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                result = i+1;
                break;
            }
        }

        return result;
    }

    //TODO  交换法

    @Test
    public void Test(){
        int[] test = new int[]{3,4,-1,1};
        firstMissingPositive(test);
    }
}
