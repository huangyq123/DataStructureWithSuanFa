package com.hyqTestForWork.Feb.Day20.Q2;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName Pailie
 * @Description TODO 47. 全排列 II 频度 medium
 * @Author huangyq
 * @Date 2022/2/20 19:27
 * @Version
 **/
public class Pailie {
    //思路没问题，但是实现细节写错了——每一次都是从剩下元素中选择一个，被选择的在index位置，因此temp和momery要记录的是这个位置而不是i；
    //使用set保存状态会比较花费空间——考虑标记数组
    public List<List<Integer>> permuteUnique(int[] nums){

        List<List<Integer>> result =new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        Arrays.sort(nums);

        dfs(nums,0,result,temp);

        return result;

    }

    public void dfs(int[] nums,int index, List<List<Integer>> result,List<Integer> temp){

        if(index>=nums.length){

            List<Integer> list = new ArrayList<>(temp);
            result.add(list);
            return ;
        }

        Set<Integer> memory = new HashSet<>();
        for(int i=index;i<nums.length;i++){
            if(memory.contains(nums[i])){
                continue;
            }
            swap(nums, index, i);
            //当前选择的元素时index，对他进行记录
            temp.add(nums[index]);
            memory.add(nums[index]);
            dfs(nums,index+1,result,temp);
            temp.remove(temp.size()-1);

            swap(nums,index,i);
        }

    }

    private void swap(int[] nums, int index, int i) {
        int tempValue = nums[index];
        nums[index] = nums[i];
        nums[i] = tempValue;
    }

    @Test
    public void Test(){
        int[] test = new int[]{1,1,2,2};
        permuteUnique(test);
    }


    //TODO  使用标记数组对重复元素做标记
}
