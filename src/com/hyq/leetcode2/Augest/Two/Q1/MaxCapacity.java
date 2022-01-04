package com.hyq.leetcode2.Augest.Two.Q1;

/**
 * @ClassName MaxCapacity
 * @Description TODO   11。盛水最多的容器
 * @Author huangyq
 * @Date 2021/8/2 17:44
 * @Version
 **/
public class MaxCapacity {
    //双指针对撞
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;

        boolean flag = height[left]>height[right]?false:true;
        int result=0;
        int temp = -1;

        while(left<right){
            if(flag){
                if(height[left]>temp){
                    int low=0;
                    if(height[left]>height[right]){
                        low = height[right];
                        flag = false;
                        temp = height[right--];
                    }else{
                        low = height[left];
                        flag = true;
                        temp = height[left++];
                    }
                    result=Math.max(result,(right-left+1)*low);
                }else{
                    left++;
                }
            }
            else{
                    if(height[right]>temp){
                        int low=0;
                        if(height[left]>height[right]){
                            low = height[right];
                            flag = false;
                            temp = height[right--];
                        }else{
                            low = height[left];
                            flag = true;
                            temp = height[left++];
                        }
                        result=Math.max(result,(right-left+1)*low);
                    }
                    else{
                        right--;
                    }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int i = maxArea(new int[]{4,3,2,1,4});
        System.out.println(i);
    }
}
