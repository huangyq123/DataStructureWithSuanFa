package com.hyqTestForWork.Feb.Day21.Q1;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName ReverseArray
 * @Description TODO 189. 轮转数组  频度 medium
 * @Author huangyq
 * @Date 2022/2/21 18:24
 * @Version
 **/
public class ReverseArray {
    //方法1：双向队列暂存，通过入队出队修改位置
    public void rotate(int[] nums, int k) {

        Deque<Integer> assist = new LinkedList<>();

        int times = k%nums.length;

        for(int i=0;i<nums.length;i++){
            assist.addLast(nums[i]);
        }

        while(times>0){
            Integer temp = assist.pollLast();
            assist.addFirst(temp);
            times--;
        }

        for(int i=0;i<nums.length;i++){
            nums[i]=assist.pollFirst();
        }

    }

    //方法二：暴力

    //方法三：原地算法_会出现问题：当吹按重复位置（回到起始点，则会导致一部分没有处理）
    public void rotate2(int[] nums, int k){
        int positionAdd = k%nums.length;
        int temp = nums[0];
        int preIndex = 0;
        boolean end = false;


            while (!end) {
                int tempIndex = (positionAdd + preIndex) % nums.length;
                int value = nums[tempIndex];
                nums[tempIndex] = temp;
                temp = value;
                preIndex = tempIndex;
                if (preIndex == 0) {
                    end = true;
                }
            }


    }

    //TODO 数组反转实现原地算法

    //TODO  数学推理优化方法三
}
