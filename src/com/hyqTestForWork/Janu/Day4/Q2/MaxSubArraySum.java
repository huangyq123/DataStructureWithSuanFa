package com.hyqTestForWork.Janu.Day4.Q2;


/**
 * @ClassName MaxSubArraySum
 * @Description TODO  53 最大连续子数组和  hot100  easy
 * @Author huangyq
 * @Date 2022/1/4 20:21
 * @Version
 **/
public class MaxSubArraySum {

    //动态规划——记录每个位置结尾的连续子数组最大和，找他们的最大值
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

    //题解：1.动态规划；2.分治

    //分治实现
}
