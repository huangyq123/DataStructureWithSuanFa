package com.hyq.leetcode.backTracing.question13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName AllSum
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/23 14:43
 * @Version
 **/
public class AllSum {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        BackTracing(result,temp,0,candidates,target);
        return result;
    }

    public static void BackTracing(List<List<Integer>> result,List<Integer> temp,int start,int[] candidates,int target){
        if(target<0)
            return ;
        if(target == 0){
            result.add(new ArrayList<>(temp));
            return ;
        }

        HashSet<Integer> set = new HashSet<>();
        for(int k = start;k<candidates.length;k++){
            if(set.contains(candidates[k]))
                continue;

            set.add(candidates[k]);
            temp.add(candidates[k]);
            BackTracing(result,temp,k+1,candidates,target-candidates[k]);//变量问题
            temp.remove(temp.size()-1);

        }

    }

    public static void swap(int[] nums,int start,int end){
        int temp = nums[start];
        nums[start]= nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        int[] test = new int[]{10,1,2,7,6,1,5};
        combinationSum2(test,8);
    }
}
