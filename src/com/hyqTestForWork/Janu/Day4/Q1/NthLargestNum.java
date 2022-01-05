package com.hyqTestForWork.Janu.Day4.Q1;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @ClassName NthLargestNum
 * @Description TODO   数组中第K个最大的数  215  hot100
 * @Author huangyq
 * @Date 2022/1/4 18:47
 * @Version
 **/
public class NthLargestNum {
    //思路：基于快排的快速选择算法——使用快排得到每一次排序后的索引位置，根据索引位置和K的关系判断是否是结果，不是则缩小区间继续快排；
    public int findKthLargest(int[] nums, int k) {
        int result=-1;
        int left=0;
        int right=nums.length-1;
        while(true) {
            result = quickSort(nums, left, right);
            if(result==nums.length-k){
                return nums[result];
            }else if(result<nums.length-k){
                left=result+1;
            }else if(result>nums.length-k){
                right=result-1;
            }
        }
    }

    public int quickSort(int[] nums,int left,int right){
        int base=nums[left];
        int index=left;

        while(left<right){
            while(right>index){
                if(nums[right]<base) {
                    nums[index] = nums[right];
                    index=right;
                    left++;
                    break;
                }else{
                    right--;
                }
            }
            while(left<index){
                if(nums[left]>=base){
                    nums[index]=nums[left];
                    index=left;
                    right--;
                    break;
                }else{
                    left++;
                }
            }
        }

        nums[left]=base;
        return left;
    }

    //题解思路：1.快排+选择；2.堆排序（大根堆）

    //堆排序实现
    public int findKthLargestByHeap(int[] nums, int k) {
        for(int m=0;m<nums.length;m++) {
            buildHeap(nums, m);
        }
        heapSort(nums,nums.length-1,k);

        return nums[nums.length-k];
    }

    public int buildHeap(int[] nums, int num){
        int parent=(num-1)/2;
        int temp=0;
        while(parent>=0) {
            if (nums[parent] >= nums[num]) {
                return parent;
            } else {
                temp = nums[num];
                nums[num] = nums[parent];
                nums[parent]=temp;
                num=parent;
                parent=(num-1)/2;
            }
        }
        return -1;
    }

    public int buildHeap2(int[] nums, int parent,int lastIndex){
        int temp=nums[parent];
        while(parent<lastIndex) {
            int child= 0;
            if(parent*2+2<=lastIndex){
                child = nums[parent*2+2]>nums[parent*2+1]?parent*2+2:parent*2+1;
            }else if(parent*2+1<=lastIndex){
                child=parent*2+1;
            }else{
                break;
            }

            if(nums[parent]>=nums[child]){
                nums[parent]=temp;
                return 0;
            }else{
                temp=nums[parent];
                nums[parent]=nums[child];
                nums[child]=temp;
                parent=child;
                temp=nums[parent];
            }
        }
        return 0;
    }

    public void heapSort(int[] nums,int lastIndex,int k){
        int temp = nums[0];

        for(int m=0;m<k;m++) {
            nums[0]=nums[lastIndex];
            nums[lastIndex]=temp;
            buildHeap2(nums, 0, lastIndex - 1);
            lastIndex--;
            temp =nums[0];
        }
    }

    @Test
    public void Test(){
        int kthLargest = findKthLargestByHeap(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        System.out.println(kthLargest);
    }
}
