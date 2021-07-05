package com.hyq.leetcode2.june.Twentyeight.Q3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName ChangeCoinTwo
 * @Description TODO  518 零钱兑换2
 * @Author huangyq
 * @Date 2021/6/28 22:05
 * @Version
 **/
public class ChangeCoinTwo {

    //有思路但是细节不会处理
    //理解 组合问题对顺序有要求，所以通过先限制使用元素的顺序来解决重复问题——本质上是二维dp
    public static int change(int amount, int[] coins) {

        int[] dp = new int[amount+1];
        dp[0]=1;

        Set<Integer> set=new HashSet<>();

        //问题：使用这种dp思想会出现大量重复——如何去重？？？

//        for(int i=1;i<dp.length;i++){
//            for(int j=0;j<coins.length;j++){
//                if(i-coins[j]>=0){
//                    if(!set.contains(i-coins[j])){
//                        dp[i]+=dp[i-coins[j]];
//                        set.add(i-coins[j]);
//                    }
//                }
//            }
//            set.clear();
//        }

        //去重实现——更换循环顺序
        for(int j=0;j<coins.length;j++){
            for(int i=1;i<dp.length;i++){
                if(i-coins[j]>=0){
                    dp[i]+=dp[i-coins[j]];
                }
            }
        }

        return dp[amount];
    }

    public static int change2(int amount, int[] coins){
        int n = coins.length;
        int[][] dp =new int[n + 1][amount + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i-1] >= 0) {
                    dp[i][j] = dp[i - 1][j]
                            + dp[i][j - coins[i-1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }


    public static void main(String[] args) {
        int change = change(5, new int[]{1, 2, 5});
        System.out.println(change);
    }
}
//总结，二维dp的组合数问题和排列数问题 都可以交换嵌套的循环，因为子问题不会变化；
// 一维的dp组合数问题和排列数问题 不可以交换嵌套的循环，因为会改变子问题；
// 一维的dp组合数问题，交换嵌套的循环，子问题会变成排列数问题；
// 一维的dp排列数问题，交换嵌套的循环，子问题会变成组合数问题；
//
// ①据题目所求可以确定是组合数问题还是排列数问题，就可以决定dp表的横纵坐标分别表示什么了，之后无论用二维dp还是一维dp，状态的横纵坐标都是不变的
// ②二维一维其实是看你的dp数组是一维还是二维决定的
// ③如果写成了一维，那么两层循环的顺序不能改变----------一维的循环顺序（只能一行一行求解）为什么不能改变呢？
// 因为如果改变循环顺序的话，变成了一列一列求，当求到第一列最后一行时，第一列前几行的数据已经被覆盖，当求第二列时，得到的数据是错的
// ④如果写成了二维，那么两层循环的顺序可以改变--------循环的顺序改变其实改变的的是一列一列求还是一行一行求，所以顺序是可以改变的（因为二维数组可以保存每一列和每一行的数据，但是一维的dp只能保存一行一行的保存数据）