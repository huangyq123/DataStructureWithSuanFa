package com.hyq.leetcode.BinarySearch.question2;

/**
 * @ClassName PackageDeliver
 * @Description TODO
 * @Author huangyq
 * @Date 2021/4/1 11:26
 * @Version
 **/
public class PackageDeliver {

    public static int shipWithinDays(int[] weights, int D) {
        int max = 0;
        int minMax = 0;
        for(int m : weights) {
            minMax = Math.max(minMax,m);
            max += m;
        }
        int start = minMax;
        int end = max;
        while(start<=end){
            int mid = start + (end-start)/2;

            if(isSuccessful(weights,D,mid))
                end = mid-1;
            else
                start = mid+1;
        }
        return start;
    }

    public static boolean isSuccessful(int[] weights,int D,int capacity){
        int days = 0;
        int count = 0;
        for(int m:weights){
            count+=m;
            if(count==capacity){
                count=0;
                days+=1;
            }else if(count>capacity){
                count=m;
                days+=1;
            }
        }
        if(count!=0)
            days+=1;

        return days<=D;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,1,1};
        int i = shipWithinDays(test, 4);
        System.out.println(i);
    }
}
