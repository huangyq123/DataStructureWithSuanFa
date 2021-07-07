package com.hyq.leetcode2.july.Six.Q2;

/**
 * @ClassName MaxProfit2
 * @Description TODO  股票买卖2  122
 * @Author huangyq
 * @Date 2021/7/6 16:58
 * @Version
 **/
public class MaxProfit2 {

    //思想——贪心算法：选取每个上涨区间，计算上涨区间的利润
    //     每两次查找作为一组——先找min位置再找max位置，使用flag表示当前查找哪一个值，每一轮查找结束更新利润。
    //      考虑边界，当走到数组最后的位置时，如果是在查找最大值，则该位置的值必然是最大值，最需要增加本次利润。

    public static int maxProfit(int[] prices) {

        int max=0;
        int min=0;
        boolean flag = true;
        int result=0;

        for(int i=0;i<prices.length-1;i++){

            if(flag&&prices[i+1]>prices[i]){
                min=i;
                flag=false;
//                max=i;
                continue;
            }
            if(!flag&&prices[i+1]<prices[i]){
                max=i;
                flag=true;
                result+=(prices[max]-prices[min]);
            }
        }

        if(!flag){
            result+=(prices[prices.length-1]-prices[min]);
        }

        return result;
    }


    //贪心优化——对于贪心来说，问题的本质是找到所有利润大于零的区间进行利润累加，那么对每一个可以进行买卖的区间，判断是否需要进行买卖就可以得到最大利润
    //贪心本质是求最大利润，不等同于交易过程
    public static int maxProfit2(int[] prices){

        int result=0;
        for(int i=0;i<prices.length-1;i++){
            //将所有有利润的区间进行保留，累加利润。
            result+=Math.max(prices[i+1]-prices[i],0);
        }
        return result;
    }

    //动态规划实现
    public static int maxProfit3(int[] prices){
        //使用数组形式
//        int[][] dp=new int[prices.length][2];
//
//        dp[0][0]=0;
//        dp[0][1]=-prices[0];
//
//        for(int i=1;i<prices.length;i++){
//            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
//            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
//        }

        //优化——使用滚动数组，节省空间
        //这里要理解每一轮迭代的时候，循环中先后顺序的影响；这里相当于引入当天买卖的操作，不会产生影响
        //动态规划进行降维优化时要注意滚动对迭代更新的影响
        int[] dp=new int[2];

        dp[0]=0;
        dp[1]=-prices[0];

        for(int i=1;i<prices.length;i++){
            dp[0]=Math.max(dp[0],dp[1]+prices[i]);
            dp[1]=Math.max(dp[1],dp[0]-prices[i]);
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int i = maxProfit(new int[]{1,2,3,4,5});
        System.out.println(i);
    }
}
