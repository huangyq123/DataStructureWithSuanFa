package com.hyqTestForWork.Feb.Day3.Q1;

import java.util.Arrays;

/**
 * @ClassName ChangeIcon
 * @Description TODO  322. 零钱兑换  频度 midium
 * @Author huangyq
 * @Date 2022/2/3 19:58
 * @Version
 **/
public class ChangeIcon {
    //看题解写的——需要在写再理解
    //TODO  重写
    public int coinChange(int[] coins, int amount){


        int[] dp = new int[amount+1];
        //初始化，保证当前的dp值不影响第一次比较大小；  同时，保证比coins中最小值小的部分状态正确
        Arrays.fill(dp,amount+1);
        // dp[0】 的值特殊考虑
        dp[0] = 0;

        for(int i=coins[0];i<dp.length;i++){
            for(int m=0;m<coins.length;m++) {
                dp[i] = i-coins[m]>=0 ? Math.min(dp[i-coins[m]]+1,dp[i]):dp[i] ;
            }
        }

        //考虑状态保存
        int result = dp[amount]>amount?-1:dp[amount];
        return result;
    }
}
