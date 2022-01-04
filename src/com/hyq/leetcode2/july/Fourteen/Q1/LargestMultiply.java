package com.hyq.leetcode2.july.Fourteen.Q1;

/**
 * @ClassName LargestMultipy
 * @Description TODO
 * @Author huangyq
 * @Date 2021/7/14 11:07
 * @Version
 **/
public class LargestMultiply {
    //动态规划——记录每一个dp[i][j]为从i到j的乘积，选取最大值
    public int maxProduct(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }

        int result=Integer.MIN_VALUE;
        int[][] dp = new int[nums.length][nums.length];
        for(int i=0;i<dp.length;i++){
            dp[i][i]=nums[i];
            result=Math.max(result,dp[i][i]);
        }


        for(int m=0;m<dp.length;m++){
            for(int n=m+1;n<dp.length;n++){
                dp[m][n]=dp[m][n-1]*nums[n];
                result=Math.max(result,dp[m][n]);
            }
        }

        return result;
    }

    //优化——没以此计算只考虑当前行大元素，dp压缩为一维数组
    public int maxProduct2(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }

        int result=Integer.MIN_VALUE;
        int[] dp = new int[nums.length];


        for(int m=0;m<dp.length;m++){
            dp[m]=nums[m];
            result=Math.max(result,dp[m]);
            for(int n=m+1;n<dp.length;n++){
                dp[n]=dp[n-1]*nums[n];
                result=Math.max(result,dp[n]);
            }
        }

        return result;
    }
}
