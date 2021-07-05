package com.hyq.leetcode2.june.TwentyNine.Q1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName Least
 * @Description TODO  435  无重叠区间
 * @Author huangyq
 * @Date 2021/6/29 20:32
 * @Version
 **/
public class Least {
    //问题：为什么使用贪心就能够计算出结果？？？
    //优化——统计删除的改为统计不删除的
    public static int eraseOverlapIntervals(int[][] intervals) {

        //排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]>o2[1]){
                    return 1;
                }else {
                    return -1;
                }
            }
        });

        //按照贪心思想统计删除的
//        int index=0;
//        int count=0;
//        boolean flag=true;
//        while(index<intervals.length){
//            int temp=index+1;
//            while(flag&&temp<intervals.length){
//                if(intervals[temp][0]<intervals[index][1]){
//                    count+=1;
//                    temp+=1;
//                }else{
//                    flag=false;
//                    index=temp;
//                }
//            }
//
//            if(temp>=intervals.length){
//                break;
//            }
//            flag=true;
//        }
//        return count;

        //按照贪心思想统计不删除的
        int count=1;
        int index=0;
        while(index<intervals.length){
            int temp=index+1;
            while(temp<intervals.length){
                if(intervals[temp][0]<intervals[index][1]){
                    temp+=1;
                }else{
                    break;
                }
            }

            if(temp>=intervals.length){
                break;
            }

            count+=1;
            index=temp;
        }
        //使用for循环更为简单

        return intervals.length-count;
    }

    public static void main(String[] args) {
//        int[][] ints = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
//        int i = eraseOverlapIntervals(ints);

        int[][] ints = {{1, 2}, {1, 2},{1, 2}};
        int i = eraseOverlapIntervals(ints);
        System.out.println(i);
    }
}
