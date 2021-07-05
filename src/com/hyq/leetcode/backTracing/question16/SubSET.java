package com.hyq.leetcode.backTracing.question16;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SubSET
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/23 20:06
 * @Version
 **/
public class SubSET {


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        BackTracing(result,temp,0,nums);
        return result;
    }

    public static void BackTracing(List<List<Integer>> result,List<Integer> temp,int start,int[] nums){

        result.add(new ArrayList<>(temp));
        if(start==nums.length)
            return ;

        for(int i =start;i<nums.length;i++){
            temp.add(nums[i]);
            BackTracing(result,temp,i+1,nums);
            temp.remove(temp.size()-1);
        }
    }
}
