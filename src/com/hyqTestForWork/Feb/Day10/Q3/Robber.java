package com.hyqTestForWork.Feb.Day10.Q3;

/**
 * @ClassName Robber
 * @Description TODO 198. 打家劫舍  频度 medium
 * @Author huangyq
 * @Date 2022/2/10 21:19
 * @Version
 **/
public class Robber {
    //经典 背包问题——动态规划
    //问题：  这一系列类似题的解法？？
    public int rob(int[] nums){

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.min(nums[0],nums[1]);

        for(int i=2;i<dp.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        return dp[dp.length-1];
    }

    //TODO  滚动数组优化
    public int rob2(int[] nums){

        int[] dp = new int[2];

        dp[0] = nums[0];
        dp[1] = Math.min(nums[0],nums[1]);

        for(int i=2;i<dp.length;i++){
            int max = Math.max(dp[1],dp[0]+nums[i]);
            dp[0] = dp[1];
            dp[1] = max;
        }

        return dp[1];
    }
}
