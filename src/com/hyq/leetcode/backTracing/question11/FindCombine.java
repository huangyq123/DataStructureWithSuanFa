package com.hyq.leetcode.backTracing.question11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName FindCombine
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/23 11:28
 * @Version
 **/
public class FindCombine {

    public static void main(String[] args) {
        int[] test = new int[]{2,3,5,7};
        combinationSum(test,7);
    }



    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        BackTracing(result,temp,0,target,candidates);
        return result;
    }

    public static void BackTracing(List<List<Integer>> result,List<Integer> temp,int start,int target,int[] candidates){
        if(target<0)
            return ;
        if(target == 0){
            result.add(new ArrayList<Integer>(temp));
            return ;
        }

        for(int i = start;i<candidates.length;i++){
            temp.add(candidates[i]);
            BackTracing(result,temp,i,target-candidates[i],candidates);
            temp.remove(temp.size()-1);
        }
    }


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        BackTracing2(result,temp,0,target,candidates);
        return result;
    }

    //剪枝优化
    public static int BackTracing2(List<List<Integer>> result,List<Integer> temp,int start,int target,int[] candidates){
        if(target<0)
            return -1;
        if(target == 0){
            result.add(new ArrayList<Integer>(temp));
            return 0;
        }

        for(int i = start;i<candidates.length;i++){
            temp.add(candidates[i]);
            int value = BackTracing2(result,temp,i,target-candidates[i],candidates);
            temp.remove(temp.size()-1);
            if(value<0)
                break;
        }
        return 0;
    }
}
