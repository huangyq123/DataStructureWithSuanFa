package com.hyqTestForWork.Feb.Day12.Q1;

import org.junit.Test;

/**
 * @ClassName Sold
 * @Description TODO  122. 买卖股票的最佳时机 II  频度 medium
 * @Author huangyq
 * @Date 2022/2/12 16:29
 * @Version
 **/
public class Sold {
    //贪心算法——取每个上升段；
    //注意——注意重置low high的时间
    public int maxProfit(int[] prices){

        int index=0;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int result = 0;
        boolean flagUp = false;
        while(index<prices.length-1){
            if(!flagUp){
                if(prices[index]<prices[index+1]){
                    low = index;
                    flagUp = true;
                }
                index++;
            }else{
                if(prices[index]>prices[index+1]){
                    high = index;
                    flagUp = false;
                    result += (prices[high]-prices[low]);
                    low = Integer.MAX_VALUE;
                    high = Integer.MIN_VALUE;
                    //找完一个上升段，进行重置
                }
                index++;
            }
        }
        //最后一个值没考虑，可能会出现一次卖出
        if(low!=Integer.MAX_VALUE){
            result +=(prices[index]-prices[low]);
        }

        return result;
    }

    @Test
    public void Test(){
        int[] test = new int[]{1,2,3,4,5};
        maxProfit(test);
    }

    //TODO  动态规划——根据当天是否持有股票，转化成背包问题
    public int maxProfit3(int[] prices){

        int index=1;
        int result = 0;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 0-prices[0];
        while(index<prices.length){
            int temp0 = Math.max(dp[0],dp[1]+prices[index]);
            int temp1 = Math.max(dp[0]-prices[index],dp[1]);
            dp[0] = temp0;
            dp[1] = temp1;
            index++;
        }


        return dp[0];
    }

    //TODO  贪心简化
    public int maxProfit2(int[] prices){

        int index=0;
        int result = 0;
        while(index<prices.length-1){
            if(prices[index]<prices[index+1]){
                result+=(prices[index+1]-prices[index]);
            }
        }


        return result;
    }
}
