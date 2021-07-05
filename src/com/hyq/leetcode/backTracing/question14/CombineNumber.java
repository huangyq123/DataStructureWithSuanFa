package com.hyq.leetcode.backTracing.question14;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CombineNumber
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/23 16:18
 * @Version
 **/
public class CombineNumber {

    public List<List<Integer>> combine(int n, int k) {
        int[] candidates = new int[n];
        for(int i =0;i<n;i++){
            candidates[i]=i+1;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        BackTracing(result,temp,0,candidates,k);
        return result;
    }

    public static void BackTracing(List<List<Integer>> result, List<Integer> temp, int start, int[] candidates, int length) {
        if (temp.size() == length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (start == candidates.length )
            return ;

        for(int k = start;k<candidates.length;k++){

            temp.add(candidates[k]);
            BackTracing(result,temp,k+1,candidates,length);
            temp.remove(temp.size()-1);

        }


    }


    //优化
    public static void BackTracing2(List<List<Integer>> result, List<Integer> temp, int start, int[] candidates, int length) {
        if (temp.size() == length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (start == candidates.length )
            return ;

        for(int k = start;k<candidates.length;k++){
            if((temp.size()+candidates.length-start)<length)        //提前剪枝
                break;
            temp.add(candidates[k]);
            BackTracing(result,temp,k+1,candidates,length);
            temp.remove(temp.size()-1);

        }


    }

}
