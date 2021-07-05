package com.hyq.day15;

/**
 * @ClassName MaxProfit
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/14 11:22
 * @Version
 **/
public class MaxProfit {


    //单次买卖
    public static int maxProfit2(int[] prices){
        if(prices==null||prices.length==0)
            return 0;

        int min = prices[0];
        int max = 0;
        for(int i =0;i<prices.length;i++){
            if(prices[i]<min)
                min = prices[i];
            max = Math.max(max,prices[i]-min);
        }
        return max;
    }

    //多次买卖；
    //问题：边界分析怎么理清楚逻辑？
    public static int maxProfit(int[] prices) {
        int pointLow = 0;
        int pointHigh = 0;
        int flag = 0;
        int profit = 0;
        while (pointLow < prices.length - 1 && pointHigh < prices.length - 1) {
            if (flag == 0) {
                while (pointLow < (prices.length - 1) && prices[pointLow] >= prices[pointLow + 1])
                    pointLow++;
                if (pointLow != prices.length - 1)
                    pointHigh = pointLow;
                flag = 1;
            } else if (flag == 1) {
                while (pointHigh < (prices.length - 1) && prices[pointHigh] <= prices[pointHigh + 1])
                    pointHigh++;
                profit += (prices[pointHigh] - prices[pointLow]);
                pointLow = pointHigh;
                flag = 0;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] test = new int[]{7,1,5,3,6,4};
        int i = maxProfit(test);
        System.out.println(i);
    }
}
