package com.hyq.leetcode3.m11d30;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName LeastQueue
 * @Description TODO
 * @Author huangyq
 * @Date 2021/11/30 20:56
 * @Version
 **/
public class LeastQueue {
    public static int leastInterval(char[] tasks, int n) {

        int[][] memory = new int[26][2];
        for(int i=0;i< tasks.length;i++){
            memory[tasks[i]-'A'][1] +=1;
        }

        for(int i=0;i<26;i++){
            memory[i][0] = i;
        }
        Comparator<int[]> compare = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return -o1[1]+o2[1];
            }
        };

        Arrays.sort(memory,compare);

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
//        for(int i=0;i<n;i++){
//            int temp = memory[0][0];
//            queue.add(temp);
//            count++;
//            memory[0][1]-=1;
//            Arrays.sort(memory,compare);
//        }

//        int times = n;
        while(memory[0][1]>0){
            count++;
            for(int i=0;i<memory.length;i++){
                if(memory[i][1]==0){
                    if(count>n) queue.poll();
                    queue.add(-1);
                    break;
                }
                if(!queue.contains(memory[i][0])) {
                    if(count>n) queue.poll();
                    int temp = memory[i][0];
                    queue.add(temp);
                    memory[i][1]-=1;
                    Arrays.sort(memory,compare);
                    break;
                }
                else if(queue.contains(memory[i][0])){
                    continue;
                }
            }


        }

        return count;
    }

    public static int leastInterval2(char[] tasks, int n) {

        int[][] memory = new int[26][2];
        for(int i=0;i< tasks.length;i++){
            memory[tasks[i]-'A'][1] +=1;
        }

        for(int i=0;i<26;i++){
            memory[i][0] = i;
        }
        Comparator<int[]> compare = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return -o1[1]+o2[1];
            }
        };

        Arrays.sort(memory,compare);

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
//        for(int i=0;i<n;i++){
//            int temp = memory[0][0];
//            queue.add(temp);
//            count++;
//            memory[0][1]-=1;
//            Arrays.sort(memory,compare);
//        }

//        int times = n;
        while(memory[0][1]>0){
            count++;
            for(int i=0;i<memory.length;i++){
                if(memory[i][1]==0){
                    if(count>n) queue.poll();
                    queue.add(-1);
                    break;
                }
                if(!queue.contains(memory[i][0])) {
                    if(count>n) queue.poll();
                    int temp = memory[i][0];
                    queue.add(temp);
                    memory[i][1]-=1;
                    Arrays.sort(memory,compare);
                    break;
                }
                else if(queue.contains(memory[i][0])){
                    continue;
                }
            }


        }

        return count;
    }

    public static void main(String[] args) {
        int i = leastInterval(new char[]{'A', 'A', 'A','B','B','B'}, 0);
        System.out.println(i);
    }


}
