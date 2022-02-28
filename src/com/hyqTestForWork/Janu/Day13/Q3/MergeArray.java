package com.hyqTestForWork.Janu.Day13.Q3;

import org.junit.Test;

/**
 * @ClassName MergeArray
 * @Description TODO 88 合并有序数组 频度 easy
 * @Author huangyq
 * @Date 2022/1/13 20:31
 * @Version
 **/
public class MergeArray {

    //双指针法
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] assist = new int[m+n];
        int point1 = 0;
        int point2 = 0;
        while(point1<m||point2<n){
            if(point1==m){
                while(point2<n){
                    assist[point1+point2]=nums2[point2];
                    point2++;
                }
            }else if(point2==n){
                while(point1<m){
                    assist[point1+point2]=nums1[point1];
                    point1++;
                }
            }else if(nums1[point1]<=nums2[point2]){
                assist[point1+point2]=nums1[point1];
                point1++;
            }else if(nums1[point1]>nums2[point2]){
                assist[point1+point2]=nums2[point2];
                point2++;
            }
        }

        for(int i =0;i<assist.length;i++){
            nums1[i]=assist[i];
        }
    }

    @Test
    public void Test(){
        int[] test1 = new int[]{1,2,3,0,0,0};
        int[] test2 = new int[]{2,5,6};
        merge(test1,3,test2,3);
    }

    //优化空间复杂度——逆向双指针
    public void merge2(int[] nums1, int m, int[] nums2, int n) {

        int point1 = m-1;
        int point2 = n-1;
        while(point1>=0||point2>=0){
            if(point1<0){
                while(point2>=0){
                    nums1[point1+point2]=nums2[point2];
                    point2--;
                }
            }else if(point2<0){
                while(point1>=0){
                    nums1[point1+point2]=nums1[point1];
                    point1--;
                }
            }else if(nums1[point1]>nums2[point2]){
                nums1[point1+point2+1]=nums1[point1];
                point1--;
            }else if(nums1[point1]<=nums2[point2]){
                nums1[point1+point2+1]=nums2[point2];
                point2--;
            }
        }


    }
}
