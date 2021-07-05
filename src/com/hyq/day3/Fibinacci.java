package com.hyq.day3;

/**
 * @ClassName Fibinacci
 * @Description TODO  循环与递归比较，使用斐波那契来实现
 * @Author huangyq
 * @Date 2021/2/26 14:12
 * @Version
 **/
public class Fibinacci {


    /**
     * @return int
     * @Author huangyq
     * @Description TODO  循环方式实现斐波那契数列
     * 理解：递归的方式从后往前，多了很多重复操作；循环的方式从第二项开始计算，
     * 每次计算结果并更新前两项，不必重复计算
     * 时间复杂度O（n）
     * @Date 2021/2/26 14:13
     * @Param [n]
     * @Version
     **/
    public int calculator(int n) {
        if (n < 0) {
            return -1;
        }//边界条件


        if (0 == n) {
            return 0;
        } else if (1 == n) {
            return 1;
        } else {
            int result1 = 0;
            int result2 = 1;
            int result = 0;
            for (int i = 1; i < n; i++) {
                result = result1 + result2;
                result1 = result2;
                result2 = result;
            }
            return result;
        }
    }

    //青蛙跳台阶
    public static int frogJumpStep(int n) {
        if (n < 0) {
            return -1;
        }//边界条件

        if (0 == n) {
            return 0;
        } else if (1 == n) {
            return 1;
        } else {
            int result1 = 1;
            int result2 = 1;
            int result = 0;
            for (int i = 1; i < n; i++) {
                result = result1 + result2;
                result1 = result2;
                result2 = result;
            }
            return result;
        }
    }

    /**
     * @return int
     * @Author huangyq
     * @Description TODO  书本样例，只是合并了一些输出情况
     * @Date 2021/2/26 14:45
     * @Param [n]
     * @Version
     **/
    public static int JumpFloor(int n) {
        if (n < 3) {
            return n;
        }
        int result = 0;
        int preOne = 2;
        int preTwo = 1;
        for (int i = 3; i <= n; i++) {
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }

    //青蛙跳台阶拓展，通过分析知道f(n)=f(n-1)+f(n-2)+...+f(1)+f(0),f(0)=1,使用数学归纳法可以得到f(n)=2^(n-1)
    public static double frogJumpStepExtend(double n) {
        if (n < 0) {
            return -1;
        }//边界条件
        if(n==0){
            return 0;
        }
            return Math.pow(2,n-1);
    }

    public static void main(String[] args) {
        int n = 100000000;
//        System.out.println(frogJumpStep(n));
//        System.out.println(JumpFloor(n));
        long start1 = System.currentTimeMillis();
        frogJumpStep(n);
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);

        long start2 = System.currentTimeMillis();
        JumpFloor(n);
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);
    }


}
