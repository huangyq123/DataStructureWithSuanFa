package com.hyq.leetcode.backTracing.question12;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AllPaiLie
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/23 14:09
 * @Version
 **/
public class AllPaiLie {

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3};
        permute(test);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        BackTracing(result,temp,0,1,nums);
        return result;
    }

    //变量——查找两、起始索引？
    public static void BackTracing(List<List<Integer>> result, List<Integer> temp, int start,int length,int[] nums){

        if(length > nums.length){
            result.add(new ArrayList<Integer>(temp));
            return ;
        }

        for(int i = start;i<nums.length;i++){
            swap(nums,i,start);
            temp.add(nums[start]);
            BackTracing(result,temp,start+1,length+1,nums);
            temp.remove(temp.size()-1);
            swap(nums,i,start);
        }
    }

    public static void swap(int[] nums,int start,int end){
        int temp = nums[start];
        nums[start]= nums[end];
        nums[end] = temp;
    }
}
