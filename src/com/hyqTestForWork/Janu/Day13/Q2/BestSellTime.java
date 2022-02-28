package com.hyqTestForWork.Janu.Day13.Q2;

/**
 * @ClassName BestSellTime
 * @Description TODO  121 买卖股票最佳时机 频度 easy
 * @Author huangyq
 * @Date 2022/1/13 20:21
 * @Version
 **/
public class BestSellTime {

    public int maxProfit(int[] prices){
        if(prices==null||prices.length<2){
            return 0;
        }

        int min = prices[0];
        int dp = 0;
        int max = 0;

        for(int i=1;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            dp = prices[i]-min;
            max = Math.max(max,dp);
        }

        return max;
    }
}
