package com.hyq.leetcode2.june.TwentyNine.Q2;

import java.util.Arrays;

/**
 * @ClassName Jump
 * @Description TODO  55   跳跃游戏
 * @Author huangyq
 * @Date 2021/6/29 21:19
 * @Version
 **/
public class Jump {

    //一维动态规划：dp[i]表示从第一个位置跳到 i 位置的可行性，每一个位置的可行性状态由 0 - i-1 位置的状态和nums[i]的值决定
    //时间效率稍低
    public static boolean canJump(int[] nums) {

        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp,false);
        dp[0]=true;

        //开始状态转移
        for(int i=0;i<dp.length;i++){
            //对于每一个位置考虑其前面的所有位置
            for(int j=0;j<i;j++){
                //能从 0 位置跳到 j 位置且能从 j 走到 i
                if(dp[j]&&nums[j]>=(i-j)){
                    dp[i]=true;
                    break;
                }
            }

        }

        return dp[nums.length-1];
    }

    public static void main(String[] args) {
//        int[] ints = {2, 3, 1, 1, 4};
//        boolean b = canJump(ints);

        int[] ints = {3,2,1,0,4};
        boolean b = canJump(ints);
        System.out.println(b);
    }

    //贪心实现？？？
}
