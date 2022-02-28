package com.hyqTestForWork.Janu.Day19.Q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName AllPailie
 * @Description TODO  46  全排列  频度  medium
 * @Author huangyq
 * @Date 2022/1/19 19:26
 * @Version
 **/
public class AllPailie {
    //注意保存过程的清理是否需要，在哪里进行
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> tempList = new ArrayList<>();
        dfs(nums,0,result,tempList);

        return result;
    }

    public void dfs(int[] nums, int index,List<List<Integer>> result, List<Integer> tempList){

        if(index==nums.length-1){
            tempList.add(nums[index]);
            List<Integer> temp = new ArrayList<>(tempList);
            result.add(temp);
            return ;
        }

        int currentIndex = index;
        for(int i=index;i<nums.length;i++){
            swap(nums,currentIndex,i);
            tempList.add(nums[currentIndex]);
            dfs(nums,index+1,result,tempList);
            swap(nums,currentIndex,i);
            tempList.remove(tempList.size()-1);
        }

    }

    public void swap(int[] nums,int pre,int next){
        int temp = nums[pre];
        nums[pre]=nums[next];
        nums[next]=temp;
    }
}
