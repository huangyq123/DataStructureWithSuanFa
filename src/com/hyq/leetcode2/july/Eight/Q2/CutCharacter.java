package com.hyq.leetcode2.july.Eight.Q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName CutCharacter
 * @Description TODO   763. 划分字母区间
 * @Author huangyq
 * @Date 2021/7/8 16:21
 * @Version
 **/
public class CutCharacter {

    //思路——转化为不重复区间的个数问题：  记录每个字母的起始和终点作为区间，遍历字符串得到所有区间；  进行排序；  对排序后的数组，将所有出现覆盖的区间进行合并得到不重复的区间，记录每个区间长度
     public static List<Integer> partitionLabels(String s) {
        int[][] memory = new int[26][2];

        //扫描获得各字母的区间
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(memory[c-'a'][0]==0){
                memory[c-'a'][0]=i;
            }
            memory[c-'a'][1]=i;
        }
        memory[s.charAt(0)-'a'][0]=0;

        //排序
        Arrays.sort(memory, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
            }
        });

        //合并区间并记录长度
        int left=memory[0][0];
        int right=memory[0][1];
        int index=1;
        List<Integer> resultTemp = new ArrayList<>();
        while(index<memory.length){
            if(memory[index][0]>right){
                resultTemp.add(right-left+1);
                left=memory[index][0];
                right=memory[index][1];
                index++;
            }else{
                right = Math.max(memory[index][1],right);
                index++;
            }
        }
        resultTemp.add(right-left+1);
        return resultTemp;
    }

    //优化——直接记录每个字母的结束位置，不记录起始位置； 从头开始扫描字符串，根据字母的结束位置记录当前区间的结束位置；
    //         在这个区间内扫描时进行区间尾巴的更新，当扫描到区间尾巴则当前区间扫描结束，记录长度，开始后面字符串的扫描


    public static void main(String[] args) {
        List<Integer> result = partitionLabels("ababcbacadefegdehijhklij");
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
}
