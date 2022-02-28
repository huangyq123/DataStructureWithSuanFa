package com.hyqTestForWork.Feb.Day15.Q4;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName tOPk
 * @Description TODO  剑指 Offer 40. 最小的k个数  频度 easy
 * @Author huangyq
 * @Date 2022/2/15 11:51
 * @Version
 **/
public class TopK {
    //优先队列
    //细节：默认是最小堆，可以自定义；  需要自己控制长度
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0||arr.length==0){
            return new int[]{};
        }

        PriorityQueue<Integer> memory = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1+o2;
            }
        });

        int index =0;
        while(index<k){
            memory.add(arr[index]);
            index++;
        }

        while(index<arr.length){
            int temp = memory.peek();
            if(temp>arr[index]){
                memory.poll();
                memory.add(arr[index]);
            }
            index++;
        }

        int[] result = new int[k];
        for(int m=0;m<k;m++){
            result[m] = memory.poll();
        }

        return result;
    }

    //TODO  快排——快选
}
