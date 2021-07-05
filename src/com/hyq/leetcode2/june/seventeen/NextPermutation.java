package com.hyq.leetcode2.june.seventeen;

import java.util.Arrays;

/**
 * @ClassName NextPermutation
 * @Description TODO  下一个排列 31
 * @Author huangyq
 * @Date 2021/6/17 18:53
 * @Version
 **/
public class NextPermutation {

    public static void nextPermutation(int[] nums) {

        if(nums==null||nums.length==1){
            return ;
        }

        int index1=-1;
        int index2=-1;

        //思路问题： 原思路——确定了要交换的高位，选择找到的组合中值最小、位置越靠右的候选项进行交换
        //boolean flag=false;

//        for(int i = nums.length-1;i>0;i--){
//            int temp = nums[i];
//            for(int m=i-1;m>=0;m--){
//                if(nums[m]<temp){
//                    if(index1<m){
//                        index1=m;
//                        index2=i;
//                        break;
//                    }else if(index1==m){
//                        if(nums[index2]<nums[i]){
//                            index2 = index2;
//                        }else if(nums[index2]>nums[i]){
//                            index2=i;
//                        }else {
//                            index2= index2>i? index2:i;
//                        }
//                        break;
//                    }
//                }
//            }
//        }

        //新思路： 确定高位，  确定后 选择高位右边比他大的最小值，交换，交换完毕后将高位右侧的数字进行从小到大排序
        //思路问题： 寻找到下一个最小不代表只是交换两位！！！！
        for(int i = nums.length-1;i>0;i--){
            int temp = nums[i];
            for(int m=i-1;m>=0;m--){
                if(nums[m]<temp){
                    if(index1<m){
                        index1=m;
                        index2=i;
                        break;
                    }else if(index1==m){
                       if(nums[index2]>temp){
                            index2=i;
                       }
                       break;
                    }
                }
            }
        }

        if(index1<0&&index2<0){
            int l=nums.length;
            for(int i=0;i<(l+1)/2;i++){
                int swap = nums[i];
                nums[i]=nums[l-i-1];
                nums[l-i-1]=swap;
            }
            // Arrays.sort(nums);
        }else{
            int swap = nums[index1];
            nums[index1]=nums[index2];
            nums[index2]=swap;

            Arrays.sort(nums,index1+1,nums.length);
        }

        return ;
    }
    //优化：  使用顺序对的方式查找index1 和 index2 ,  使用双指针反转数组而不用排序

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3};
        int[] test1 = new int[]{1,1,5};
        int[] test2 = new int[]{3,2,1};
        int[] test3 = new int[]{1,3,2};
        nextPermutation(test);
        nextPermutation(test1);
        nextPermutation(test2);
        nextPermutation(test3);

        Arrays.sort(test2);
        System.out.println(1);
    }
}
