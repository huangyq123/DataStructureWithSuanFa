package com.hyq.leetcode2.Augest.Eleven.Q3;

/**
 * @ClassName SquareNum
 * @Description TODO  279. 完全平方数
 * @Author huangyq
 * @Date 2021/8/11 16:29
 * @Version
 **/
public class SquareNum {
    //问题：思路错误，从最大的开始找找到的不一定是最少的
    //被数学性质困住了，没有去思考问题类型
    public static int numSquares(int n) {
        int target = n;
        int count=0;
        while(target>0){
            target-=find(target);
            count+=1;

        }

        return count;
    }

    public static int find(int target){
        while(target>0) {
            int sqrt = (int) Math.sqrt(target);
            if (sqrt * sqrt == target) {
                return target;
            }
            target--;
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = numSquares(12);
        System.out.println(i);
//        System.out.println( Math.sqrt(25));
    }
}
