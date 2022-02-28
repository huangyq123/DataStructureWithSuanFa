package com.hyqTestForWork.Feb.Day17.Q5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SumKArray
 * @Description TODO  560. 和为 K 的子数组  频度 medium
 * @Author huangyq
 * @Date 2022/2/17 20:34
 * @Version
 **/
public class SumKArray {

    public int subarraySum(int[] nums, int k) {
        int result =0;
        int dp =0;


        for(int m=0;m<nums.length;m++){
            dp = nums[m];
            result = dp==k?result+1:result;
            for(int n=m+1;n<nums.length;n++){
                int temp = dp+nums[n];
                if(temp==k){
                    result+=1;
                }
                dp = temp;
            }
        }

        return result;
    }

    //TODO  前缀和+哈希表
    //需要学习  前缀和的应用
    //子数组类前缀和——注意第一个位置是否计算——提前存放元素
    public int subarraySum2(int[] nums, int k){
        //记录当前前缀和
        int dp = 0;
        int result =0;
        //记录前一位置前缀和
        int sum = 0;
        //当前遍历的数组位置
        int index=0;
        //记录已经遍历的前缀和
        Map<Integer,Integer> memory = new HashMap<>();
        //注意前置——当第一个元素需要计算，则应该减去0
        memory.put(0,1);
        while(index<nums.length){
            //计算当前前缀和
            dp = sum + nums[index];
            //判断数量
            if(memory.containsKey(dp-k)){
                Integer integer = memory.get(dp - k);
                result+=integer;
            }
            //保存当前数据
            if(memory.containsKey(dp)) {
                memory.put(dp, memory.get(dp)+1);
            }else{
                memory.put(dp,1);
            }
            //更新前缀和
            sum = dp;
        }

        return result;
    }

}
