package com.hyq.leetcode2.july.Eight.Q1;

import java.util.Arrays;

/**
 * @ClassName InsertSpace
 * @Description TODO  插入区间  57
 * @Author huangyq
 * @Date 2021/7/8 14:52
 * @Version
 **/
public class InsertSpace {
    //思路——查找新插入区间会覆盖哪些原区间，记录start和end对应覆盖的区间位置，将这些区间合并
    //  问题——逻辑还是稍微复杂了，想法是尽量利用原数组，不额外增加数组，同时避免时间开销
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals.length==0){
            return new int[][]{{newInterval[0],newInterval[1]}};
        }

        //初始化记录参数
        int flagLeft=-1;
        int flagRight=-1;
        int index=0;
        while(index<intervals.length){
            //start位置还未找到，继续查找
            if(flagLeft==-1){
                //newIntever[0]落在将当前区间以及 当前区间和前一个区间的间断中，都可能覆盖当前区间
                if(newInterval[0]<=intervals[index][1]){
                    flagLeft=index;
                }
            }
            //查找end
            if(flagRight==-1){
                //newIntever[1]落在将当前区间以及 当前区间和前一个区间的间断中，都可能覆盖当前区间
                if(newInterval[1]<=intervals[index][1]){
                    flagRight=index;
                }
            }
            //查找完毕
            if(flagLeft!=-1&&flagRight!=-1){
                break;
            }
            index++;
        }

        //结果记录
        int[][] result = new int[intervals.length+1][2];
        //合并后区间的首尾位置
        int start=0;
        int end=0;
        int i=0;
        //计数
        int count=0;
        while(i<intervals.length){
            //当前区间没有被覆盖，新区间在该区间之后
            if(i!=flagLeft){
                result[i]=intervals[i++];
                count++;
            }
            //新区间的开始位置是这个区间开始
            else if(i==flagLeft){
                start = Math.min(newInterval[0],intervals[i][0]);
                //考虑newInterval[1]是否比最后一个区间的值要大，如果不是
                if(flagRight!=-1){
                    if(newInterval[1]<intervals[flagRight][0]){
                        end = newInterval[1];
                    }else{
                        end = intervals[flagRight][1];
                        flagRight+=1;
                    }
                }
                //如果是，则直接覆盖往后所有区间
                else{
                    end=newInterval[1];
                }
                //记录新区间
                result[i++]=new int[]{start,end};
                count+=1;
                break;
            }
        }

        //分情况分析：是否在新区间后还存在原区间。  无的情况
        if(flagRight==-1){
            if(flagLeft==-1){
                result[i]=newInterval;
                count++;
            }
            return Arrays.copyOfRange(result,0,count);
        }
        //还存在原区间
        while(flagRight<intervals.length){
            result[i++]=intervals[flagRight++];
            count++;
        }
        //根据计数值返回找到的区间
       return Arrays.copyOfRange(result,0,count);
    }

    //优化思路——判断当前区间是否可以加入结果，若不能说明需要进行区间合并；若能则直接添加。

    public static void main(String[] args) {
//        int[][] insert = insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
        int[][] insert2 = insert(new int[][]{{1,5}}, new int[]{2,7});

        for(int k=0;k<insert2.length;k++){
            System.out.println(insert2[k][0]+"  "+insert2[k][1]);
        }
    }
}
