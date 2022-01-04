package com.hyq.leetcode2.july.Sixteen.Q1;

import java.util.Arrays;

/**
 * @ClassName Temperature
 * @Description TODO 739. 每日温度
 * @Author huangyq
 * @Date 2021/7/16 19:06
 * @Version
 **/
public class Temperature {
    //时间效率太低，和暴力法基本没有差别
    public static int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        int index1=0;
        int index0=0;
        int count=0;
        boolean[] flag= new boolean[temperatures.length];
        Arrays.fill(flag,false);
        while(index0<temperatures.length){
            if(flag[index0]){
                index0++;
                continue;
            }
            index1=index0+1;
            int current = index0;
            while(index1<temperatures.length){
                count++;
                if(temperatures[index1]>temperatures[current]){
                    result[current]=count;
                    count=0;
                    flag[current]=true;
                    current=index1;

                }
                index1++;
            }
            result[current]=0;
            flag[current]=true;
            index0++;
            count=0;
        }
//        result[result.length-1]=0;
        return result;

    }

    //思路：单调栈


    public static void main(String[] args) {
        int[] ints = dailyTemperatures(new int[]{55,38,53,81,61,93,97,32,43,78});
        for(int i:ints){
            System.out.print(i+"   ");
        }
    }
}
