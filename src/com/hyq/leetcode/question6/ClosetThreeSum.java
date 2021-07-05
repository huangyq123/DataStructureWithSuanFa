package com.hyq.leetcode.question6;

import java.util.Arrays;

/**
 * @ClassName ClosetThreeSum
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/21 18:55
 * @Version
 **/
public class ClosetThreeSum {


    //问题：返回值？
    //      边界条件改变（end\start去的操作）
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null)
            return -1;
        if (nums.length < 3)
            return -1;

        Arrays.sort(nums);
        int resultFinal = nums[0] + nums[1] + nums[nums.length - 1];
        int result = Math.abs(resultFinal - target);
        for (int k = 0; k < nums.length - 2; k++) {
            int start = k + 1;
            int end = nums.length - 1;

            while (start < end) {
                int temp = nums[k] + nums[start] + nums[end] - target;
                int abstemp = Math.abs(temp);

//                if(abstemp<result&&temp<0){
//                    result = temp;
//                    while (start<end&&nums[start]!=nums[start+1])
//                        start++;
//                }else if(abstemp<result&&temp>0){
//                    result = temp;
//                    while (start<end&&nums[end]!=nums[end-1])
//                        end--;
//                }else if(abstemp==result&&temp>0){
//                    while (start<end&&nums[end]!=nums[end-1])
//                        end--;
//                }else if(abstemp)

                if (abstemp < result) {
                    result = abstemp;
                    resultFinal = nums[k]+nums[start]+nums[end];
                }

                if (temp == 0) {
                    break;
                } else if (temp > 0) {
                    end--;
                    while (start < end && nums[end] == nums[end + 1])
                        end--;
                } else {
                    start++;
                    while (start < end && nums[start] == nums[start - 1])
                        start++;
                }
            }
            if (result == 0)
                break;
        }

        return resultFinal;
    }

    public static void main(String[] args) {
        int[] test = new int[]{-1, 0,1,1,55};
        int i = threeSumClosest(test, 3);
        System.out.println(i);
    }
}
