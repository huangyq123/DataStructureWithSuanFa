package com.hyqTestForWork.March.Day10.Q1;
/**
 *@Author admin
 *@Description TODO  4. 寻找两个正序数组的中位数  hard
 *@Date 2022/3/10 17:34
 *@Param
 *@return
 *@Version
 **/
public class FindMedium {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {



        int num = (nums1.length+nums2.length)%2;
        int result1 = -1;
        int result2 = -1;

        result1 = search(nums1, nums2, (nums1.length + nums2.length) / 2);
        if(num==0){
            result2 = search(nums1, nums2, (nums1.length + nums2.length) / 2 + 1);
            return (double) (result1+result2)/2;
        }else{
            return (double) result1;
        }

    }

    //TODO  实现二分查找
    public int search(int[] nums1,int[] nums2,int k){


        int medium1 = 0;
        int medium2 = 0;

        int start1 = 0;
        int start2 = 0;
        int end1 = nums1.length-1;
        int end2 = nums2.length-1;

        int residual = k;
        while(residual!=0){
            if(k/2-1+start1>end1){
                return -1;
            }


        }

        return -1;
    }
}
