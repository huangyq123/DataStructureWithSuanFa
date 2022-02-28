package com.hyqTestForWork.Feb.Day14.Q3;

/**
 * @ClassName MaxSubArray
 * @Description TODO  152. 乘积最大子数组  频度 medium
 * @Author huangyq
 * @Date 2022/2/14 21:13
 * @Version
 **/
public class MaxSubArray {
    public int maxProduct(int[] nums){

        int result = Integer.MIN_VALUE;
        int dp = 0;


        for(int m=0;m<nums.length;m++){
            dp = nums[m];
            result = Math.max(dp,result);
            for(int n=m+1;n<nums.length;n++){
                int temp = dp *nums[n];
                result = Math.max(result,temp);
                dp = temp;
            }
        }

        return result;
    }

    //TODO  一次遍历实现
}
