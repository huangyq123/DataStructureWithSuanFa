package com.hyq.leetcode2.july.Six.Q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName MaxProfit3
 * @Description TODO   股票买卖4   188
 * @Author huangyq
 * @Date 2021/7/6 18:11
 * @Version
 **/
public class MaxProfit4 {

    //问题：当受到k限制时，当K小于得到最大利润的买卖次数时，如果不存在区间重叠，则可以取前K个最大的，但是一旦有重叠，则需要进行区间重叠来扩展区间——如何选择重叠方案？？？
    public static int maxProfit(int k,int[] prices) {

        ArrayList<Integer> low = new ArrayList<>();
        boolean flag = true;
        int result=0;

        for(int i=0;i<prices.length-1;i++){
            if(flag&&prices[i+1]>prices[i]){
                low.add(prices[i]);
                flag=false;
                continue;
            }
            if(!flag&&prices[i+1]<prices[i]){
                low.set(low.size()-1,prices[i]-low.get(low.size()-1));
                flag=true;
            }
        }

        if(!flag){
            low.set(low.size()-1,prices[prices.length-1]-low.get(low.size()-1));
        }

        Integer[] resultArray =new Integer[low.size()];
        for(int i=0;i<resultArray.length;i++){
            resultArray[i]=low.get(i);
        }

        Arrays.sort(resultArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(int m=0;m<Math.min(resultArray.length,k);m++){
            result+=resultArray[m];
        }

        return result;
    }

    //尝试使用重叠区间的去重算法来处理，但是出现问题：如何选择去重个数和去重的区间？？
    public static int maxProfit2(int k,int[] prices) {

        ArrayList<Integer> low = new ArrayList<>();
        boolean flag = true;
        int result=0;

        for(int i=0;i<prices.length-1;i++){
            if(flag&&prices[i+1]>prices[i]){
                low.add(prices[i]);
                flag=false;
                continue;
            }
            if(!flag&&prices[i+1]<prices[i]){
                low.add(prices[i]);
                flag=true;
            }
        }

        if(!flag){
            low.add(prices[prices.length-1]);
        }

        int[][] resultArray =new int[low.size()][2];
        for(int i=0;i<resultArray.length;i+=2){
            resultArray[i][0]=low.get(i);
            resultArray[i][1]=low.get(i+1);
        }

        Arrays.sort(resultArray, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });


        return result;
    }


    //解题思路：三维动态规划——降维解决
    //理解： 列举出所有可能就可以得到答案，因此是穷举问题，考虑动态规划。  状态定义：目标值是求最大利润，考虑dp表示当前条件下的最大利润。 ——状态dp受到的影响：当前是否持有股票；进行过的交易次数；当前是第几天
    //      因此，考虑dp[i][k][s]表示第i天进行了k次交易状态为s的情况下得到的最大利润。进行状态转移。
    //      要注意：并非完成交易次数越多越好
    //重点——边界条件的处理
    //周五到周日重写一遍


    public static void main(String[] args) {
        int[] test = new int[]{1,2,4,2,5,7,2,4,9,0};
        int i = maxProfit(2, test);
        System.out.println(i);
    }
}
