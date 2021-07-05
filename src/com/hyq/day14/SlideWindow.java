package com.hyq.day14;

/**
 * @ClassName SlideWindow
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/12 14:34
 * @Version
 **/
public class SlideWindow {

    public static int[] maxSlidingWindow(int[] nums, int k){
        if(nums==null)
            return null;
        if(k>nums.length||nums.length==0)
            return new int[]{};

        int low = 0;
        int high = k-1;
        int max= nums[low];
        for(int i = low;i<=high;i++){           //得到第一个窗口，初始化最大值
            max = Math.max(max,nums[i]);
        }

        int[] result = new int[nums.length-k+1];
        result[0]=max;
        int count = 0;

        while(high<nums.length-1){            //开始寻找下一个窗口
            high+=1;
            low+=1;
            if(nums[high]>=max){                //加入元素比前一个窗口最大值大，直接更新
                max = nums[high];
                result[++count]=max;
            }else if(nums[high]<max){           //新元素比前一个最大值小
                if(nums[low-1]!=max){          //若删除元素非最大值，则最大值不变
                    result[++count]=max;
                }else{                        //删除最大值，则重新遍历查找最大值
                    max = nums[low];
                    for(int t = low;t<=high;t++)
                        max = Math.max(max,nums[t]);
                    result[++count]=max;
                }
            }
        }
        return result;
    }
}
