package com.hyq.leetcode2.june.Twentyeight.Q2;

import java.util.Arrays;

/**
 * @ClassName Partition
 * @Description TODO  416  分割等和子集
 * @Author huangyq
 * @Date 2021/6/28 20:10
 * @Version
 **/
public class Partition {

    //背包问题思路——确定状态：物品是什么、背包容量是什么；   确定转移方式；   确定初始化值
    //问题：对状态的的定义和理解还是不够明确
    public boolean canPartition(int[] nums) {

        int temp=0;
        for(int k: nums){
            temp+=k;
        }
        if(temp%2!=0){
            return false;
        }

        temp/=2;

        boolean[][] dp = new boolean[nums.length+1][temp+1];
        for(boolean[] t:dp){
            Arrays.fill(t,false);
        }
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }



        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                dp[i][j]=dp(nums,i-1,j,dp)|dp(nums,i-1,j-nums[i-1],dp);
            }
        }

        return dp[nums.length][temp];
    }

    public boolean dp(int[] nums,int i,int j,boolean[][] dp){
        if(i<0||j<0){
            return false;
        }else{
            return dp[i][j];
        }
    }

    //优化——提高空间利用率
    public boolean canPartition2(int[] nums) {

        int temp=0;
        for(int k: nums){
            temp+=k;
        }
        if(temp%2!=0){
            return false;
        }

        temp/=2;

        boolean[] dp = new boolean[temp+1];
        for(boolean t:dp){
            t=false;
        }
        dp[0]=true;
        for(int i=0;i<nums.length;i++){
            for(int j=dp.length-1;j>0;j--){
                if(j-nums[i]>0) {
                    dp[j] = dp[j] | dp[j - nums[i]];
                }
            }
        }
        //使用一维数组进行压缩时，考虑到每一次更新时当前存储的数组数据都包括这一次遍历和上一次遍历的结果，因此要分清楚遍历顺序
        //对于这个问题来说，若从前往后遍历，后面的会使用到前面的结果，可是前面的结果是这一次遍历的过程中更新的，因此会出错
        return dp[temp];
    }
}
