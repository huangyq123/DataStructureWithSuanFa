package com.hyqTestForWork.Feb.Day5.Q3;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LongestArray
 * @Description TODO  128. 最长连续序列  频度 medium
 * @Author huangyq
 * @Date 2022/2/5 21:27
 * @Version
 **/
public class LongestArray {
    //问题——空间使用过多   且无法处理重复   错误解法
    public int longestConsecutive(int[] nums){

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
            }
            if(nums[i]<min){
                min = nums[i];
            }
        }

        int[] memory = new int[max-min+1];
        if(min<0) {
            memory[0 - min] = -1;
        }
        for(int i=0;i<nums.length;i++){
            int temp = nums[i];
            memory[temp-min] = temp;
        }

        int length = 0;
        int start = 0;
        int end = -1;
        for(int i=0;i<memory.length;i++){
            if(memory[i]==i+min){
                end +=1;
            }else{
                length = end-start+1>length?end-start+1:length;
                while(i<memory.length&&(memory[i]!=i+min)){
                    i++;
                }
                start=i;
            }
        }



        return length;
    }

    @Test
    public void Test(){
        int[] test = new int[]{100,4,200,1,3,2};
        longestConsecutive(test);
    }


    //TODO  哈希表实现O(N)复杂度
    public int longestConsecutive2(int[] nums){
        Set<Integer> memory = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!memory.contains(nums[i])){
                memory.add(nums[i]);
            }
        }
        int maxLength=0;
        int length = 0;
        for(int temp:memory){
            if(memory.contains(temp-1)){
                continue;
            }

            length +=1;
            while(memory.contains(temp+1)){
                length+=1;
            }

            maxLength = Math.max(maxLength,length);
        }

        return maxLength;
    }
}
