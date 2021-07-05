package com.hyq.day11;

import java.util.ArrayList;

/**
 * @ClassName MediumNumberOfDataStream
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/9 9:56
 * @Version
 **/
public class MediumNumberOfDataStream {
    private ArrayList<Integer> memory ;

    /** initialize your data structure here. */
    public MediumNumberOfDataStream() {
        memory = new ArrayList<Integer>();
    }

    public void addNum(int num) {
        memory.add(num);
    }

    //优先队列的使用？
    //效率问题
    public double findMedian() {
        int length = memory.size();

        int medium1 = length/2;
        int start =0;
        int end = length-1;
        while(start<end){
            int temp = partition(memory,start,end);
            if(temp==medium1)  break;
            if(temp>medium1)  end = temp-1;
            if(temp<medium1)  start =temp+1;
        }

        int result1 = memory.get(medium1);
        if((length&1)==1)
           return (double) result1;
        else{
            int medium2 = length/2-1;
            int start2 =0;
            int end2 = length-1;
            while(start2<end2){
                int temp2 = partition(memory,start2,end2);
                if(temp2==medium2)  break;
                if(temp2>medium2)  end2 = temp2-1;
                if(temp2<medium2)  start2 =temp2+1;
            }
            int result2 = memory.get(medium2);
            return ((double) (result1+result2))/2.0;
        }
    }

    public int partition(ArrayList<Integer> nums, int start,int end){
        int base = nums.get(start);
        int left = start;
        int right = end;

        while (left < right) {
            while (left < right && nums.get(right) >= base)
                right--;
            while (left < right && nums.get(left)<= base)
                left++;

            swap(nums, left, right);
        }
        if (left != start)
            swap(nums, start, left);
        return left;
    }

    public  void swap(ArrayList<Integer> nums, int start, int end) {
        Integer temp = nums.get(start);
        nums.set(start,nums.get(end)) ;
        nums.set(end,temp);
    }
}
