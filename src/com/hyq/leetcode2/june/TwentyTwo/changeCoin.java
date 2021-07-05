package com.hyq.leetcode2.june.TwentyTwo;

import java.util.Arrays;

/**
 * @ClassName changeCoin
 * @Description TODO  零钱兑换 322
 * @Author huangyq
 * @Date 2021/6/22 19:26
 * @Version
 **/
public class changeCoin {

    //思路错误——不该从最大值开始往下减
    public static int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }

        Arrays.sort(coins);
        int count=0;
        int temp=amount;
        int index = isExists(coins, temp);

        while(index>=0){
            temp-=coins[index];
            count+=1;
            if(temp>0){
                index=isExists(coins, temp);
            }else if(temp==0){
                break;
            }
        }

        if(temp==0){
            return count;
        }else if(index<0){
            return -1;
        }

        return 0;
    }

    public static int isExists(int[] coins, int temp){
        int i =coins.length-1;
        for(;i>=0;i--){
            if(coins[i]<=temp){
                return i;
            }else{
                continue;
            }
        }
        return i;
    }

    //动态规划——看题解写出来的， 不是很理解
    //问题：  怎么分析是一个动态规划问题？  怎么处理（穷举、状态定义、状态转移）
    public static int coinChange2(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }

        Arrays.sort(coins);

        int[] dp= new int[amount+1];

        //Arrays.fill(dp, amount+1);
        //实现填充

        for(int i=1;i<=amount;i++){
            dp[i]=amount+1;
            for(int k=0;k<coins.length;k++){
                if((i-coins[k])>=0){
                    dp[i]=Math.min(dp[i],dp[i-coins[k]]+1);
                }
            }
        }

        return dp[amount]==amount+1? -1: dp[amount];
    }

    public static void main(String[] args) {
        int[] test = new int[]{186,419,83,408};
        int i = coinChange2(test, 6249);
        System.out.println(i);
    }
}
