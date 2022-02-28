package com.hyqTestForWork.Janu.Day20.Q3;

/**
 * @ClassName LongestSubArray
 * @Description TODO  300 最长上升子序列  频度 medium
 * @Author huangyq
 * @Date 2022/1/20 16:34
 * @Version
 **/
public class LongestSubArray {
    //思路一  动态规划   想到了这个揭发，但是觉得时间复杂度偏高，和暴力解法没什么区别
    public int lengthOfLIS(int[] nums){
        if(nums==null||nums.length==0){
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for(int i=1;i<nums.length;i++){
            int max = 1;
            for(int m=0;m<i;m++){
                if(nums[m]<nums[i]){
                    max = Math.max(max,dp[m]+1);
                }
            }
            dp[i] = max;
            result = Math.max(result,dp[i]);
        }

        return result;
    }


    //TODO 思路二  使用二分和贪心   1.21
}
