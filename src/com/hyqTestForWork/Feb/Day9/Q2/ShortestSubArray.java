package com.hyqTestForWork.Feb.Day9.Q2;

import org.junit.Test;

/**
 * @ClassName ShortestSubArray
 * @Description TODO  209. 长度最小的子数组  频度 medium
 * @Author huangyq
 * @Date 2022/2/9 16:02
 * @Version
 **/
public class ShortestSubArray {
    //思路没问题，但是实现的时候细节没想清楚&手误导致一堆小bug
    // ——想清楚细节、变量含义，写的时候写清楚；
    public int minSubArrayLen(int target, int[] nums) {

        int length = 0;
        int result = nums.length+1;
        int tempTarget = target;

        int slow = -1;
        int fast = 0;
        boolean flag = true;
        while(fast<nums.length){
            if(flag) {
                tempTarget -= nums[fast];
                length+=1;
                if(tempTarget<=0){
                    result = Math.min(result,length);
                    flag=false;
                }else{
                    fast+=1;
                }
            }else{
                slow+=1;
                tempTarget+=nums[slow];
                length-=1;
                if(tempTarget>0){
                    result = Math.min(result,length+1);
                    flag=true;
                    fast+=1;
                }else if(tempTarget==0){
                    result = Math.min(result,length);
                    flag = true;
                    fast+=1;
                }
            }
        }

        return result==nums.length+1?0:result;
    }


    //TODO  优化写法


    //TODO  二分+前缀和
    //注意细节：sum需要比num长一个，否则会出现包含不了第一个元素的情况（也可以在初始化时进行处理）；
    public int minSubArrayLen2(int target, int[] nums){
        int[] sum = new int[nums.length+1];
        sum[0] = 0;
        int temp = 0;
        for(int i=1;i<sum.length;i++){
            temp +=nums[i-1];
            sum[i] = temp;
        }

        int length = nums.length+1;
        for(int k=0;k<sum.length;k++){
            int start = k+1;
            int end = sum.length-1;
            int medium = start;
            while(start<=end){
                medium = start + (end-start)/2;
                if(sum[medium]-sum[k]<target){
                    start = medium+1;
                }else if(sum[medium]-sum[k]>=target){
                    end = medium - 1;
                }
            }
            if(start<sum.length) {
                length = Math.min(length, start - k);
            }
        }


        return length==nums.length+1?0:length;
    }

    @Test
    public void Test(){
        int[] test = new int[]{1,1,1,1,1,1,1,1};
        int i = minSubArrayLen2(8, test);
        System.out.println(i);
    }
}
