package com.hyq.leetcode2.july.Four.Q1;

import java.util.Arrays;

/**
 * @ClassName LongestSubSequence
 * @Description TODO  最长递增子序列  300
 * @Author huangyq
 * @Date 2021/7/4 15:15
 * @Version
 **/
public class LongestSubSequence {

    //动态规划思想——定义dp[n]为位置从0-n的数组的最长子序列，得到每一个位置的最长子序列，选取最大值。
    //          ——dp[n] = max(dp[m]\dp[k]\...) 其中，候选元素是位置在n左边且元素值比n位置元素值小的位置，
    //          ——basecase 为n<0，考虑到dp[m]可能已经计算过，设置判断条件结束递归
    //          ——考虑当第m位置前面没有元素比她小时，该元素的dp值为1，需要特殊处理
    public static int lengthOfLIS(int[] nums) {

        int[] dp=new int[nums.length];
        dp[0]=1;
        int result=0;
        for(int m=nums.length-1;m>=0;m--){
           result=Math.max(result,dp(nums, dp, m));
        }

        return result;
    }

    public static int dp(int[] nums,int[] dp,int index){

        if(index<0){
            return 0;
        }
        if(dp[index]!=0){
            return dp[index];
        }

        for(int i=index-1;i>=0;i--){
            if(nums[i]<nums[index]){
                dp[index]=Math.max(dp(nums,dp,i)+1,dp[index]);
            }
        }

        if(dp[index]==0){
            dp[index]=1;
        }

        return dp[index];
    }


    //迭代实现
    public static int lengthOfLIS2(int[] nums){
        if(nums.length==1){
            return 1;
        }

        int[] dp = new int[nums.length];

        Arrays.fill(dp,1);

        int result=0;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            result=Math.max(result,dp[i]);
        }

        return result;
    }



    public static void main(String[] args) {
        int i = lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
//        int i = lengthOfLIS(new int[]{0,1,0,3,2,3});
//        int i= lengthOfLIS2(new int[]{1,3,6,7,9,4,10,5,6});
        System.out.println(i);

    }
}
