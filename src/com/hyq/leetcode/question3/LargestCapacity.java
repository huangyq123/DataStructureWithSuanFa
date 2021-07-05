package com.hyq.leetcode.question3;

/**
 * @ClassName LargestCapacity
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/19 15:57
 * @Version
 **/
public class LargestCapacity {
    //双指针收缩
    public static int maxArea2(int[] height){
        int max = 0;
        int low = 0;
        int high = height.length-1;
        while(low<high){
            max = Math.max(max,Math.min(height[low],height[high])*(high-low));
            if(height[low]<height[high])
                low++;
            else
                high--;
        }
        return max;
    }

    //时间效率
    public static int maxArea(int[] height) {
        if(height==null||height.length==0)
            return 0;
        int max = 0;
        for(int m = 0;m<height.length;m++){
            for(int n = m+1;n<height.length;n++){
                int capacity = Math.min(height[m],height[n])*(n-m);
                max = Math.max(capacity,max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(test));
    }
}
