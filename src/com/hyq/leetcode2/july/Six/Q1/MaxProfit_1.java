package com.hyq.leetcode2.july.Six.Q1;

/**
 * @ClassName MaxProfit_1
 * @Description TODO  股票买卖——1  121
 * @Author huangyq
 * @Date 2021/7/6 16:33
 * @Version
 **/
public class MaxProfit_1 {

    //思路——动态规划：定义dp[n]为在 0-n 天中完成买卖的最大利润
    //      状态转移：当计算dp[n]时，两种情况——prices[n]比之前记录的最大值要大，则更新最大利润dp[n]=prices[n]-prices[min]；
    //                              当比之前的最大值要小时，dp[n]=dp[n-1]，要注意，这时候prices[n]可以作为计算 n+1\n+2..时的最小值，因此需要进行更新
    //由于每一次计算dp[n]最多用到一个dp值，因此简化 一维数组 为一个 数
    public static int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];

        int minIndex=0;
        int maxIndex=0;
        int result =0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]-prices[minIndex]>=result){
                result=prices[i]-prices[minIndex];
                maxIndex=i;
            }else{
                if(prices[minIndex]>prices[i]){
                    minIndex=i;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int i = maxProfit(new int[]{7,6,4,3,1});
        System.out.println(i);
    }
}
