package com.hyq.leetcode2.Augest.Eleven.Q1;

import java.util.*;

/**
 * @ClassName KlargestNumber
 * @Description TODO  347. 前 K 个高频元素
 * @Author huangyq
 * @Date 2021/8/11 15:16
 * @Version
 **/
public class KlargestNumber {
    //思路：先遍历简化数组，再快速排序（直接调），复杂度 mlogm,m是不重复的元素个数
    //问题：可能出现极端情况，即所有元素不重复
    // 想到了使用k大小的数组来处理但是想不出来如何处理——需要学习堆排序的使用和实现
    public static int[] topKFrequent(int[] nums, int k) {
        List<Integer> temp = new ArrayList<>();
        int count=0;
        for(int i:nums){
            if(!temp.contains(i)){
                count++;
                temp.add(i);
            }
        }

        int[][] total = new int[temp.size()][2];
        for(int m:nums){
            int i = temp.indexOf(m);
            total[i][0]=m;
            total[i][1]+=1;
        }

        Arrays.sort(total, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });

        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=total[i][0];
        }
        return result;
    }

    //优化思路：简化数组后使用堆排序——
    //时间复杂度由于需要维护的堆的大小而提升



    public static void main(String[] args) {
        int[] test=new int[]{1,1,1,2,2,3,4,4,4,4};
        int[] ints = topKFrequent(test, 2);
        for(int m:ints){
            System.out.print(m+"  ");
        }
    }
}
