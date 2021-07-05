package com.hyq.leetcode.backTracing.question15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName AllPaiLieTwo
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/23 16:42
 * @Version
 **/
public class AllPaiLieTwo {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        BackTracing(result,temp,0,nums);
        return result;
    }

    public static void BackTracing(List<List<Integer>> result, List<Integer> temp, int start,int[] nums){

        if(temp.size() == nums.length){
            result.add(new ArrayList<Integer>(temp));
            return ;
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = start;i<nums.length;i++){
            if(set.contains(nums[i]))
                continue;
            set.add(nums[i]);
            swap(nums,start,i);
            temp.add(nums[start]);
            BackTracing(result,temp,start+1,nums);
            temp.remove(temp.size()-1);
            swap(nums,start,i);

        }
    }

    public static void swap(int[] nums,int start,int end){
        int temp = nums[start];
        nums[start]= nums[end];
        nums[end] = temp;
    }
}
