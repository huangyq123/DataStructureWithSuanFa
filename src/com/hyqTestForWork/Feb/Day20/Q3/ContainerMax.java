package com.hyqTestForWork.Feb.Day20.Q3;

/**
 * @ClassName ContainerMax
 * @Description TODO  11. 盛最多水的容器  频度 medium
 * @Author huangyq
 * @Date 2022/2/20 20:09
 * @Version
 **/
public class ContainerMax {
    //对撞指针——面积等于底*高；  底在缩小，只有短边变大才有可能得到更大容量——根据短边位置开始往中间缩
    public int maxArea(int[] height) {

        int result = 0;

        int start = 0;
        int end = height.length - 1;
        int prev = -1;
        int flag = 0;

        while (end > start) {
            if (flag == 0 && height[end] <= prev) {
                end--;
                continue;
            }
            if (flag == 1 && height[start] <= prev) {
                start++;
                continue;
            }

            result = Math.max(Math.max(height[start], height[end]) * (end - start), result);
            if (height[start] > height[end]) {
                prev = height[end];
                end--;
                flag = 0;
            } else {
                prev = height[start];
                start++;
                flag = 1;
            }
        }

        return result;
    }
}
