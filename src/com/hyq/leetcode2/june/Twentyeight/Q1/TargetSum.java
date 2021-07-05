package com.hyq.leetcode2.june.Twentyeight.Q1;

import java.util.Arrays;

/**
 * @ClassName TargetSum
 * @Description TODO  目标和  494  回溯\dp  分别实现
 * @Author huangyq
 * @Date 2021/6/28 18:56
 * @Version
 **/
public class TargetSum {


    //方法一：回溯
    public static int findTargetSumWays(int[] nums, int target) {

        int temp=0;
        int[] result=new int[]{0};

        trace(nums,0,target,temp,result);

        return result[0];
    }


    public static void trace(int[] nums, int position,int target,int currentSum,int[] result){
        //回溯结束条件
        if(position>=nums.length){
           if(target==currentSum){
               result[0]+=1;
           }
           return ;
        }

        //状态修改+方向选择性递归
        currentSum+=nums[position];
        trace(nums,position+1,target,currentSum,result);

        //状态修改+方向选择性递归
        currentSum-=nums[position]*2;
        trace(nums,position+1,target,currentSum,result);


        return ;
    }
    //通过测试用例 但是回溯法时间效率低


    //dp的实现需要使用背包问题——后面学了再回来看
    public static int findTargetSumWays2(int[] nums, int target) {


        //排除特殊情况
        int temp=0;
        for(int t:nums){
            temp+=t;
        }

        if(target>temp||target+temp<0){
            return 0;
        }

        //初始化dp矩阵
        int[][] dp = new int[nums.length+1][temp*2+2];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int j =0;j<dp[0].length;j++){
            dp[0][j]=0;
        }
        dp[0][temp+1]=1;

        //开始状态转移
        for(int i =1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                //注意边界问题
                if((j-nums[i-1])>=0&&(j+nums[i-1])<dp[0].length){
                    dp[i][j]=dp[i-1][j-nums[i-1]]+dp[i-1][j+nums[i-1]];
                }
                else if((j-nums[i-1])>=0){
                    dp[i][j]=dp[i-1][j-nums[i-1]];
                }else if((j+nums[i-1])<dp[0].length){
                    dp[i][j]=dp[i-1][j+nums[i-1]];
                }
            }
        }


        return dp[nums.length][temp+target+1];
    }
//通过用例
    //问题：坐标的对应关系理的有点乱——特别注意nums[i]和当前[i]的关系；

    //优化点：可以转化为子集背包问题，这样不会存在复杂的数值对应关系，思路更清晰，还可以优化成一维dp

    public static void main(String[] args) {
        int targetSumWays2 = findTargetSumWays2(new int[]{1, 1, 1, 1, 1}, 3);
        int targetSumWays22 = findTargetSumWays2(new int[]{1000}, 1000);
        System.out.println(targetSumWays22);
    }

}
