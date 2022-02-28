package com.hyqTestForWork.Feb.Day4.Q1;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName SumZuHe
 * @Description TODO 39. 组合总和  频度 medium
 * @Author huangyq
 * @Date 2022/2/4 9:35
 * @Version
 **/
public class SumZuHe {
    //这个写法可以，但是去重的实现过于浪费空间
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        Set<String> memory = new HashSet<>();
        dfs(result,temp,target,candidates,memory);

        return result;

    }

    public void dfs(List<List<Integer>> result,List<Integer> temp,int target,int[] candidates,Set<String> memory ){
        if(target==0){
            Integer[] integers = temp.toArray(new Integer[temp.size()]);
            Arrays.sort(integers);
            String s = "";
            for(int i=0;i<integers.length;i++){
                s = s + integers[i] + " ";
            }

            if(!memory.contains(s)) {
                memory.add(s);
                List<Integer> add = new ArrayList<>(temp);
                result.add(add);
            }
            return ;
        }

        for(int i=0;i<candidates.length;i++){
            int tempTarget = target - candidates[i];
            if(tempTarget<0){
                break;
            }
            temp.add(candidates[i]);
            dfs(result,temp,tempTarget,candidates,memory);
            temp.remove(temp.size()-1);
        }

        return ;
    }


    //TODO 2.5 组合通过索引去重
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);  // 这一步无所谓，只是为了方便剪枝

        dfs2(result,temp,target,candidates,0);
        return result;
    }

    public void dfs2(List<List<Integer>> result,List<Integer> temp,int target,int[] candidates,int index){
        if(target==0){
            List<Integer> integers = new ArrayList<>(temp);
            result.add(integers);
            return ;
        }
        //每次玄奇一个索引开始进行元素增加，只有index之后的会被考虑，保证不会出现重复
        for(int i=0;i<candidates.length-index;i++) {
            int tempValue = candidates[index+i];
            if(target-tempValue>=0){  //提前结束递归，剪枝
                temp.add(tempValue);
                dfs2(result, temp, target - tempValue, candidates, index + i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    @Test
    public void Test(){
        int[] test = new int[]{2,3,6,7};
        combinationSum(test,7);
    }
}
