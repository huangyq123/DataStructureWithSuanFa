package com.hyq.leetcode2.july.Seven.Q1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName Over
 * @Description TODO   覆盖区间  1288
 * @Author huangyq
 * @Date 2021/7/7 19:09
 * @Version
 **/
public class Over {

    //思路——将数组按照第一个位置进行升序排列，同样大小则按照第二个位置降序排列
    //  第一个位置每个值只能出现一次，所有只需要考虑每一个不同起始点的数组；  由于是按照升序排列，后面的数组的第一个位置的元素必定会被包含，只需要考虑第二个位置的值是否被前面已选择的区间包含，即判断最大值和该位置值的关系。
    public static int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }else{
                    return o2[1]-o1[1];
                }
            }
        });

        int count=0;
        int max=0;
        int temp=intervals[0][0];
        //起始值
        int index=0;
        //开始扫描
        while(index<intervals.length){
            //intervals[i][1]没有被包含
            if(intervals[index][1]>max){
                count+=1;
                max=intervals[index++][1];
            }
            //跳过所有第一个元素和intervals[i][0]相同的区间
            while(index<intervals.length) {
                if (intervals[index][0] == temp){
                    index++;
                }else if (intervals[index][0] != temp) {
                    //下一个intervals[i][0]
                    temp = intervals[index][0];
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{0,3},{1,4},{1,3},{1,5},{2,6},{3,9},{3,6},{2,8}};
        int i = removeCoveredIntervals(test);
        System.out.println(i);
    }

}
