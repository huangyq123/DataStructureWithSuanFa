package com.hyqTestForWork.Janu.Day20.Q6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName ClimbStairs
 * @Description TODO  56  合并区间  频度 medium
 * @Author huangyq
 * @Date 2022/1/20 20:53
 * @Version
 **/
public class MergeIntervals {
    //参考了一点题解，细节上把握不好 TODO 1.21
    public int[][] merge(int[][] intervals){

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });

        List<Integer[]> tempResult = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for(int i=1;i< intervals.length;i++){
            if(intervals[i][0]==left){
                right = intervals[i][1];
            }else{
                if(intervals[i][1]<=right){
                    continue;
                }else if(intervals[i][0]>right){
                    tempResult.add(new Integer[]{left,right});
                    left = intervals[i][0];
                    right = intervals[i][1];
                }else{
                    right = intervals[i][1];
                }
            }
        }

        tempResult.add(new Integer[]{left,right});

        int[][] integers = new int[tempResult.size()][2];
        for(int m=0;m<tempResult.size();m++){
            integers[m][0]=tempResult.get(m)[0];
            integers[m][1]=tempResult.get(m)[1];
        }

        return integers;
    }

    @Test
    public void Test(){
        int[][]test = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        merge(test);
    }
}
