package com.hyqTestForWork.Janu.Day13.Q1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName TwoSum
 * @Description TODO 1 两数之和  频度 easy
 * @Author huangyq
 * @Date 2022/1/13 19:37
 * @Version
 **/
public class TwoSum {

    //考虑低时间复杂度
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums==null||nums.length<2){
            return null;
        }

        int[][] memory = new int[nums.length][2];
        for (int i=0;i<nums.length;i++){
            memory[i][0]=nums[i];
            memory[i][1]=i;
        }

        Arrays.sort(memory, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int left = 0;
        int right = nums.length-1;
        int lastFirst = memory[left][0];
        int lastSecond = memory[right][0];
        while(left<right){
            if(memory[left][0]+memory[right][0]==target){
                result[0]=memory[left][1];
                result[1]=memory[right][1];
                break;
            }else if(memory[left][0]+memory[right][0]<target){
                lastFirst = memory[left][0];
                while(left<right&&lastFirst==memory[left][0]) {
                    left++;
                }
            }else if(memory[left][0]+memory[right][0]>target){
                lastSecond = memory[right][0];
                while(left<right&&lastSecond==memory[right][0]) {
                    right--;
                }
            }
        }

        return result;
    }

    //哈希表解法——O(n)
    //理解——因为只有一个答案，不用排序；用哈希表保证只遍历一次就可
}
