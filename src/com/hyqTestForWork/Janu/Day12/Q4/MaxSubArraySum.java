package com.hyqTestForWork.Janu.Day12.Q4;

/**
 * @ClassName MaxSubArraySum
 * @Description TODO 53  最大子序和
 * @Author huangyq
 * @Date 2022/1/12 21:06
 * @Version
 **/
public class MaxSubArraySum {
    //1.4版本-dp
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0]=nums[0];
        int max = dp[0];

        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    //1.12-分治法——  1.13任务-学习线段树
    public int maxSubArray2(int[] nums){



        return -1;
    }
}
