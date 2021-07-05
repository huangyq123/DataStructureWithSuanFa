package com.hyq.leetcode2.july.Four.Q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName MultiSpace
 * @Description TODO  消除重叠区间 56
 * @Author huangyq
 * @Date 2021/7/4 16:21
 * @Version
 **/
public class MultiSpace {

    //
    public static int[][] merge(int[][] intervals) {

        //按照左端点升序排列区间
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int index=0;
        int temp=index;
        ArrayList<Integer>  result= new ArrayList<>();
        //开始合并区间
        for(int i=1;i<intervals.length;i++){
            //更新区间右端点最大值所在位置的记录
            if(intervals[i][0]<=intervals[temp][1]){
                temp=intervals[i][1]>=intervals[temp][1]?i:temp;
            }else{
                //找到一个连续区间，下一个区间开始和当前区间间断，对当前连续区间左右端点进行保存
                result.add(intervals[index][0]);
                result.add(intervals[temp][1]);
                index=i;
                temp=index;
            }
        }

        //保存左后一个区间
        result.add(intervals[index][0]);
        result.add(Math.max(intervals[intervals.length-1][1],intervals[temp][1]));

        //建立成数组进行返回
        int[][] finalResult=new int[result.size()/2][2];
        for(int m=0;m<result.size();m+=2){
            finalResult[m/2][0]=result.get(m);
            finalResult[m/2][1]=result.get(m+1);
        }
        return finalResult;
    }

    public static void main(String[] args) {
//        int[][] test = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] test = new int[][]{{0,0},{0,1},{3,3}};
        int[][] merge = merge(test);

        System.out.println(1);
    }
}
