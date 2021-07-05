package com.hyq.leetcode2.july.One.Q1;

import java.util.Arrays;

/**
 * @ClassName JumpGameTwo
 * @Description TODO  45 跳跃游戏2
 * @Author huangyq
 * @Date 2021/7/1 19:12
 * @Version
 **/
public class JumpGameTwo {

    //思路——动态规划：dp[n]表示能跳到当前位置n的最少步数，状态转移：dp[n]=min{dp[n-1],dp[n-2],...dp[0]},(需要保证能够从0跳到当前位置)
    public static int jump(int[] nums) {

        int[] dp = new int[nums.length];
        //状态记忆，记录能否能从0跳到
        boolean[] status = new boolean[nums.length];
        Arrays.fill(status,false);
        dp[0]=0;
        status[0]=true;

        for(int i=1;i<dp.length;i++){
            int min=nums.length;
            for(int j=0;j<i;j++) {
                if (status[j]&&nums[j]>=(i-j)){
                    min = Math.min(min,dp[j]+1);
                }
            }
            if(min<nums.length){
                status[i]=true;
                dp[i]=min;
            }
        }

        return dp[nums.length-1];
    }

    //问题： 起始本质上不算是动态规划——每一个位置遍历了所以可能，效率太低
    //自顶向下的实现？？？？？？

    //贪心算法实现
    public static int jump2(int[] nums){
        if(nums.length==1){
            return 1;
        }

        int index=0;
        int start=0;
        int end=0;
        int distance=0;
        int result=0;
        while(index<nums.length){
            if(nums[index]+index>=nums.length-1){
                result++;
                break;
            }
            end=index+nums[index];
            start=index+1;

            distance=0;
            for(int k=start;k<=end;k++){
                if(distance<(nums[k]+k)){
                    index = k;
                    distance=nums[k]+k;
                }
            }
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        int jump = jump2(new int[]{2, 3, 1, 1, 4});
        System.out.println(jump);
    }
}
