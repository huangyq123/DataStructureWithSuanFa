package com.hyq.leetcode2.july.Nineteen.Q1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Cource
 * @Description TODO  207. 课程表
 * @Author huangyq
 * @Date 2021/7/19 16:23
 * @Version
 **/
public class Cource {

    //问题：一个元素有多个前驱则当前方法不适用
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean flag=true;
        int[] temp = new int[numCourses];
        Arrays.fill(temp,-1);

        //记录前驱
        for(int i=0;i<prerequisites.length;i++){
            int index=prerequisites[i][0];
            temp[index]=prerequisites[i][1];
        }

        //集合，用来存储已经遍历过的元素
        Set<Integer> memory= new HashSet<>();

        //开始遍历
        for(int i=0;i<prerequisites.length;i++){
            //一斤遍历过则忽略
            if(memory.contains(prerequisites[i][0])){
                continue;
            }
            //用来记录本次遍历的 链 中的元素，如果出现重复则会构成环，失败
            Set<Integer> c= new HashSet<>();
            int current=prerequisites[i][0];
            //还未遍历到链头，继续操作
            while(temp[current]!=-1){
                //记录
                c.add(current);
                //已经构成环
                if(c.contains(temp[current])){
                    flag=false;
                    break;
                }
                //不成环，继续遍历，并进行记录
                current=temp[current];
//                c.add(current);
            }
            //存在环
            if(!flag) {
                break;
            }
            //记录本次遍历的链元素，避免重复查找遍历
            memory.addAll(c);
        }
        return flag;
    }


    //题解：BFS遍历


    public static void main(String[] args) {
        boolean b = canFinish(3, new int[][]{{1, 0}, {1, 2}, {0, 1}});
        System.out.println(b);
    }
}
