package com.hyqTestForWork.Feb.Day18.Q2;

/**
 * @ClassName PowOfN
 * @Description TODO 50. Pow(x, n) 频度 medium
 * @Author huangyq
 * @Date 2022/2/18 20:05
 * @Version
 **/
public class PowOfN {
    //思路正确，但是对快速幂的计算理解不够透彻，没能实现；   注意细节——n越界、n可以是负（要看清楚题目条件），注意边界是否需要处理；
    //对于数值较大的问题、计算次数大的问题，要注意边界值；
    public double myPow(double x, int n) {

        double result = 1;
        double temp = x;
        long times =n;
        if(n<0){
            times *= -1 ;
        }

        while(times>0){
            if((times&1)==1){
                result*=temp;
            }
            temp*=temp;
            times=times>>>1;
        }

        return n>0?result:1/result;
    }

    //TODO  理解快速幂   整理边界处理类问题
}
