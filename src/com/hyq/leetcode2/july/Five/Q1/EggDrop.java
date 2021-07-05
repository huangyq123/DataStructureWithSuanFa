package com.hyq.leetcode2.july.Five.Q1;

import java.util.Arrays;

/**
 * @ClassName EggDrop
 * @Description TODO   鸡蛋掉落  887   需要重写
 * @Author huangyq
 * @Date 2021/7/5 16:26
 * @Version
 **/
public class EggDrop {

    //思路错误——没有理解最小和最坏的含义
    public static int superEggDrop(int k, int n) {

        int[] status=new int[n+1];
        Arrays.fill(status,2);

        status[0]=0;

        int result=0;

        for(int i=0;i<status.length;i++){
            status[i]=1;
            result=Math.max(result,find(status));
            status[i]=0;
        }

        return result;
    }

    public static int find(int[] status){
        int times=0;

        int left=0;
        int right=status.length-1;
        while(left<=right){
            times+=1;
            int medium = left+(right-left)/2;
            if(status[medium]>1){
                right=medium-1;
            }else if(status[medium]<2){
                left=medium+1;
            }
        }

        return times;
    }


    //动态规划


    public static void main(String[] args) {
        int i = superEggDrop(3,14);
        System.out.println(i);
    }

}
