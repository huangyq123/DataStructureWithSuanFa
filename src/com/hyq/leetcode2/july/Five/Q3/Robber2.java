package com.hyq.leetcode2.july.Five.Q3;

import java.util.Arrays;

/**
 * @ClassName Robber2
 * @Description TODO   打家劫舍2  213
 * @Author huangyq
 * @Date 2021/7/5 18:15
 * @Version
 **/
public class Robber2 {

    //问题：时间效率——三次循环时间效率太低，  根本原因在于状态定义的问题
    //问题2：环转换为两个数组的理由？？
    public static int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }


        int[] temp = new int[nums.length-1];

        int result=0;

        for(int k=0;k<nums.length;k++){
            change(temp,nums,k);
            int[] dp= new int[nums.length-1];
            dp[0]=temp[0];
            if(dp.length>1) {
                dp[1]=temp[1];
            }
            for(int i=2;i<temp.length;i++){
                for(int j=0;j<i-1;j++){
                    dp[i]=Math.max(dp[j]+temp[i],dp[i]);
                }
            }
            result =Math.max(dp[dp.length-1],result);
        }


        return result;
    }

    public static void change(int[] temp,int[] nums,int time){
        for(int k=0;k<temp.length;k++){
            temp[k]=nums[(k+time+1)%nums.length];
        }
    }

    //优化,类似上一个打家劫舍的思想
    public static int rob2(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }

        int[] temp = new int[nums.length-1];
        int result=0;
        int[] dp= new int[nums.length-1];

        for(int k=0;k<2;k++){
            change(temp,nums,k);
            Arrays.fill(dp,0);
            dp[0]=temp[0];
            dp[1]=Math.max(temp[1],temp[0]);
            for(int i=2;i<dp.length;i++){
                dp[i]=Math.max(dp[i-2]+temp[i],dp[i-1]);
            }
            result =Math.max(dp[dp.length-1],result);
        }


        return result;
    }

    public static void main(String[] args) {
        int rob = rob2(new int[]{4,1,2,7,5,3,1});
        System.out.println(rob);
    }
}
