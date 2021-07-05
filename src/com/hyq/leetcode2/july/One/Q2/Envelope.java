package com.hyq.leetcode2.july.One.Q2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName Envelope
 * @Description TODO  信封嵌套   354
 * @Author huangyq
 * @Date 2021/7/1 20:03
 * @Version
 **/
public class Envelope {

    //问题：排序的思想——LIS问题的套路？？？？
    //思路——现排序，后面根据状态转移得到各位置最大嵌套数量，并取最大值
    public static int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]-o2[0]<0){
                    return -1;
                }else if(o1[0]-o2[0]==0){
                    return o1[1]-o2[1]>0?1:-1;
                }else {
                    return 1;
                }
            }
        });

        int result=1;
//        int width=envelopes[0][0];
//        int height=envelopes[0][1];

        int[] dp= new int[envelopes.length];
        Arrays.fill(dp,1);
        //这个贪心不合理
//        for(int i=1;i<envelopes.length;i++){
//            if(envelopes[i][0]>width&&envelopes[i][1]>height){
//                result+=1;
//                width=envelopes[i][0];
//                height=envelopes[i][1];
//            }
//        }

        for(int i=1;i<dp.length;i++){
            int width=envelopes[i][0];
            int height=envelopes[i][1];
            int max=0;
            //进行状态转移，遍历从 0-i-1的所有可用状态作为候选量
            for(int j=0;j<i;j++){
                if(envelopes[j][0]<width&&envelopes[j][1]<height){
                    max=Math.max(max,dp[j]+1);
                }
            }
            //记录当前位置的结果和临时最大值
            dp[i]=max==0?1:max;
            result=Math.max(result,dp[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}};
//        int[][] ints = new int[][]{{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
//        int[][] ints = new int[][]{{46,89},{50,53},{52,68},{72,45},{77,81}};

        int i = maxEnvelopes(ints);
        System.out.println(i);
    }
}
