package com.hyq.leetcode2.july.Twelve.Q1;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LongestSequence
 * @Description TODO   128 最长连续序列
 * @Author huangyq
 * @Date 2021/7/12 18:55
 * @Version
 **/
public class LongestSequence {
    //问题——没思路  这个处理方式超时： 从min到max遍历时，遍历个数可能出现比nums.length长得多的情况，会浪费时间
    public static int longestConsecutive(int[] nums) {
        Set<Integer> temp = new HashSet<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int k=0;k<nums.length;k++){
            if(temp.contains(nums[k])) {
                continue;
            }
            temp.add(nums[k]);
            min=Math.min(min,nums[k]);
            max=Math.max(max,nums[k]);
        }

        int current=min;
        int length=0;
        while(current>=min&&current<=max){
            int tempLength=0;
            for(;current<=max;current++){
                if(temp.contains(current)) {
                    tempLength+=1;
                }else{
                    current++;
                    while(!temp.contains(current)&&current<=max){
                        current++;
                    }
                    break;
                }
            }
            length=Math.max(length,tempLength);
        }

        return length;
    }

    //改进：取set中的数进行遍历查找序列
    public static int longestConsecutive2(int[] nums) {
        Set<Integer> temp = new HashSet<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int k=0;k<nums.length;k++){
            if(temp.contains(nums[k])) {
                continue;
            }
            temp.add(nums[k]);
        }

        int current=min;
        int length=0;
        //改进：只查找存在于数组中的情况；同时，考虑优化，只从每一段的起始点开始查找
        for(int x:temp){
            if(temp.contains(x-1)){
                continue;
            }
            int tempLength=1;
            x+=1;
            while(temp.contains(x)){
                tempLength++;
                x++;
            }
            length=Math.max(length,tempLength);
        }


        return length;
    }

    public static void main(String[] args) {
        int i = longestConsecutive2(new int[]{100,4,200,1,3,2});
        System.out.println(i);
    }
}
