package com.hyq.day11;

/**
 * @ClassName SonArrayMaxSum
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/9 11:11
 * @Version
 **/
public class SonArrayMaxSum {



    //动态规划
    public int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0)
                dp[i] = nums[i];
            else
                dp[i] = dp[i - 1] + nums[i];
        }
        int max = dp[0];
        for (int i = 1; i < dp.length; i++)
            if (dp[i] > max)
                max = dp[i];
        return max;
    }
//优化
    public int maxSubArray3(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1]>0)
                nums[i] = nums[i - 1] + nums[i];
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++)
            if (nums[i] > max)
                max = nums[i];
        return max;
    }
}
