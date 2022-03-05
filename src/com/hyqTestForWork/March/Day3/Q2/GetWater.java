package com.hyqTestForWork.March.Day3.Q2;

import java.util.Map;

/**
 *@Author admin
 *@Description TODO  42. 接雨水  hard
 *@Date 2022/3/3 21:57
 *@Param
 *@return
 *@Version
 **/

public class GetWater {
    //TODO 重新理解一下——参考了题解：每一个位置的接水量取决于他的两边的最高值的较小者
    public int trap(int[] height) {

        int[] leftHeight = new int[height.length];
        int[] rightHeight = new int[height.length];
        leftHeight[0] = height[0];
        rightHeight[rightHeight.length-1] = height[height.length-1];
        for(int i=1;i<height.length;i++){
            if(height[i]>leftHeight[i-1]){
                leftHeight[i] = height[i];
            }else{
                leftHeight[i] = leftHeight[i-1];
            }

            if(height[height.length-1-i]>rightHeight[height.length-i]){
                rightHeight[height.length-1-i] = height[height.length-1-i];
            }else{
                rightHeight[height.length-1-i] = rightHeight[height.length-i];
            }
        }

        int result = 0;
        for(int i=0;i<height.length;i++){
            result+=(Math.min(leftHeight[i],rightHeight[i])-height[i]);
        }

        return result;
    }
}
