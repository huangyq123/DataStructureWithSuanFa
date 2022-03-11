package com.hyqTestForWork.March.Day11.Q1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *@Author admin
 *@Description TODO  239. 滑动窗口最大值  hard
 *@Date 2022/3/11 16:50
 *@Param
 *@return
 *@Version
 **/
public class MaxValueOfSlide {
    //不会，看题解——单调队列
    public int[] maxSlidingWindow(int[] nums, int k){

        if(nums==null||nums.length<k){
            return new int[]{};
        }


        int start = 0;
        int end = 0;

        int[] result = new int[nums.length-k+1];
        Deque<Integer> queue = new LinkedList<>();
        while(end<k){
            if(queue.isEmpty()){
                queue.add(nums[end]);
            }else{
                while(!queue.isEmpty()&&queue.peekLast()<nums[end]){
                    queue.pollLast();
                }
                queue.addLast(nums[end]);
            }
            end++;
        }

        result[0] = queue.peekFirst();

        while(end<nums.length){
            while(!queue.isEmpty()&&queue.peekLast()<nums[end]){
                queue.pollLast();
            }
            queue.addLast(nums[end]);

            if(queue.peekFirst()==nums[start]){
                queue.pollFirst();
            }
            start++;
            end++;

            result[start] = queue.peekFirst();
        }

        return result;

    }


    //TODO  优先队列
}
