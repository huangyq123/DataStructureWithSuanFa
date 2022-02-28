package com.hyqTestForWork.Feb.Day15.Q1;

/**
 * @ClassName FeiBonaqi
 * @Description TODO 剑指 Offer 10- I. 斐波那契数列   剑指 Offer 10- II. 青蛙跳台阶问题  频度 easy
 * @Author huangyq
 * @Date 2022/2/15 10:36
 * @Version
 **/
public class FeiBonaqi {
    //递推问题——找递推公式，考虑动态规划、快速幂
    public int fib(int n) {
        if(n==0||n==1){
            return n;
        }
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for(int m=2;m<=n;m++){
            int temp = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = temp;
        }

        return dp[1];
    }

    //TODO  矩阵快速幂
}
