package com.hyqTestForWork.Feb.Day6.Q2;

/**
 * @ClassName findPeek
 * @Description TODO  162. 寻找峰值  频度 medium
 * @Author huangyq
 * @Date 2022/2/6 16:03
 * @Version
 **/
public class findPeek {
    //二分法： 根据medium的值和start\end 的值判断哪一边存在峰，进行二分；
    //考虑边界——只有两个元素的处理
    //这个逻辑没问题但是还是有些乱，还需要学习一下题解逻辑
    public int findPeakElement(int[] nums) {
        if(nums==null){
            return -1;
        }else if(nums.length==1){
            return 0;
        }

        int start=0;
        int end = nums.length-1;
        int medium = start;
        while(start<end){
            if(start+1==end){
                return nums[start]>nums[end]?start:end;
            }
            medium = start+(end-start)/2;
            if(nums[medium]<nums[start]){
                end=medium-1;
            }else if(nums[medium]<nums[end]){
                start= medium+1;
            }else {
                if(nums[medium]>nums[medium-1]&&nums[medium]>nums[medium+1]){
                    return medium;
                }else if(nums[medium]>nums[medium-1]){
                    start=medium+1;
                }else {
                    end=medium-1;
                }
            }
        }

        return start;
    }

    //TODO 爬坡式理解  2.7
    //按照形状来划分，根据相邻值来判断二分区间
    public int findPeakElement2(int[] nums){
        if(nums==null){
            return -1;
        }

        int start = 0;
        int end = nums.length-1;
        int medium = 0;

        while(start<end){
            if(start+1==end){
                return nums[start]>nums[end]?start:end;
            }

            medium = start + (end-start)/2;

            if(nums[medium]>nums[medium+1]&&nums[medium]>nums[medium-1]){
                return medium;
            }else if(nums[medium]>nums[medium+1]&&nums[medium]<nums[medium-1]){
                end = medium-1;
            }else if(nums[medium]<nums[medium+1]&&nums[medium]>nums[medium-1]){
                start = medium+1;
            }else if(nums[medium]<nums[medium+1]&&nums[medium]<nums[medium-1]){
                start = medium+1;
            }
        }

        return start;
    }

    //爬坡优化——经典二分
    //理解——为了避免最后start+1=end的判断，把所有情况包括在if-else中，考虑使用一个值来划分区间（从二分的角度也应该是一个值来进行划分）；
    //      同时，也可以减少if-else的判断；
    //  实现—— 四种情况按照右边界划分为两种：  因为要保证被比较的数在索引范围内， 而 medium 必定是 start和end种效地那一个，因此，选择medium+1而不是medium-1；
    //
    public int findPeakElement3(int[] nums){
        if(nums==null){
            return -1;
        }

        int start = 0;
        int end = nums.length-1;
        int medium = 0;

        while(start<=end){
            if(start==end){
                break;
            }
            medium = start + (end-start)/2;
            if(nums[medium]>nums[medium+1]){
                end = medium;
            }else if(nums[medium]<nums[medium+1]){
                start = medium+1;
            }
        }

        return start;
    }


}
