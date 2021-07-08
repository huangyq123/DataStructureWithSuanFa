package com.hyq.leetcode2.july.Seven.Q2;

import java.util.ArrayList;

/**
 * @ClassName CommonSpace
 * @Description TODO   986. 区间列表的交集
 * @Author huangyq
 * @Date 2021/7/7 19:59
 * @Version
 **/
public class CommonSpace {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int[][] sum = new int[firstList.length+secondList.length][2];

        int index=0;
        int indexF=0;
        int indexS=0;
        while(index<sum.length){
            if(indexF>=firstList.length){
                while(indexS<secondList.length) {
                    sum[index++] = secondList[indexS++];
                }
            }else if(indexS>=secondList.length){
                while(indexF<firstList.length) {
                    sum[index++] = firstList[indexF++];
                }
            }else if(firstList[indexF][0]>=secondList[indexS][0]){
                sum[index++] = secondList[indexS++];
            }else if(secondList[indexS][0]>firstList[indexF][0]){
                sum[index++] = firstList[indexF++];
            }
        }

        index=0;
        int min=sum[0][0];
        int max=sum[0][1];
        ArrayList<Integer> result = new ArrayList<>();
        for(int k=1;k<sum.length;k++){
            if(sum[k][0]<=max){
                result.add(sum[k][0]);
                result.add(Math.min(sum[k][1],max));
                max=Math.max(sum[k][1],max);
            }else{
                min=sum[k][0];
                max=sum[k][1];
            }
        }

        int[][] r=new int[result.size()/2][2];
        for(int m=0;m<result.size();){
            r[m/2][0]=result.get(m++);
            r[m/2][1]=result.get(m++);
        }

        return r;
    }

    public static void main(String[] args) {
        int[][] test1 = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] test2 = new int[][]{{1,5},{8,12},{15,24},{25,26}};
        int[][] ints = intervalIntersection(test1, test2);
        for(int w=0;w<ints.length;w++){
            System.out.println(ints[w][0]+"  "+ints[w][1]);
        }
    }
}
