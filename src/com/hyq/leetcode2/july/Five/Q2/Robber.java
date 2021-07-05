package com.hyq.leetcode2.july.Five.Q2;

/**
 * @ClassName Robber
 * @Description TODO   打家劫舍  198
 * @Author huangyq
 * @Date 2021/7/5 17:58
 * @Version
 **/
public class Robber {

    //思路——可以穷举所有子数组组合：动态规划问题。  考虑定义状态数组：只有一个影响因素——位置，因此考虑用一维数组进行dp。
    //      dp[n]:从0开始，打劫到n位置的情况下，打劫了该位置用户时得到的最多财物。
    //      状态转移：dp[n]的值由0 - n-2 打劫到的最大财物加上 n 位置的财物， 即 dp[n] = nums[n] + max(dp[m],dp[j],...) ,  m,j<n-1

    //问题：时间复杂度？？？——使用哪种方式写动态规划效率更好？？？，状态定义？？？
    public static int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }

        int[] dp= new int[nums.length];

        dp[0]=nums[0];
        dp[1]=nums[1];
        int result =Math.max(dp[0],dp[1]);

        for(int i=2;i<nums.length;i++){
            for(int j=0;j<i-1;j++){
                dp[i]=Math.max(dp[j]+nums[i],dp[i]);
            }

            result =Math.max(dp[i],result);
        }

        return result;
    }


    //优化
    //状态定义——dp[n]表示有0-n个用户是时打劫到的最多财富
    public static int rob2(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }

        int[] dp= new int[nums.length];

        //base case
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        //第n个位置两种情况：被打劫或者不被打劫
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }

        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int rob = rob2(new int[]{2,7,9,3,1});
        System.out.println(rob);

    }
}
