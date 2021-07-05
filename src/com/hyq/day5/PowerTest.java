package com.hyq.day5;

/**
 * @ClassName Power
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/2 9:13
 * @Version
 **/
public class PowerTest {

    //考虑边界条件的情况
    public static double Power(double base, int exponent) {
        double temp = base;
        if (Double.toString(0.0).equals(Double.toString(base))) {
            if (exponent >= 0)
                return 0;
            else
                return 0;
        }
        if (exponent > 0) {
            for (int i = 1; i < exponent; i++)
                temp *= base;
        } else if (exponent < 0) {
            int exponentAbs = -1 * exponent;
            for (int i = 1; i < exponentAbs; i++)
                temp *= base;
            temp = 1.0 / temp;
        } else
            temp = 1;

        return temp;
    }


    //在边界之外，还考虑执行效率的实现
    public static double Power2(double base, int exponent) {
        double temp = base;
        if (Double.toString(0.0).equals(Double.toString(base))) {
            if (exponent >= 0)
                return 0;
            else
                return 0;
        }

        if (exponent > 0) {
            temp = ExponentCount2(base, exponent);
        } else if (exponent < 0) {
            int exponentAbs = -1 * exponent;
            temp = ExponentCount2(base, exponent-1);//考虑int范围
            temp = 1.0 / temp  * 1.0 / base;
        } else
            temp = 1;

        return temp;
    }

    public static double ExponentCount(double base, int exponent) {
        if(exponent==0)//?考虑int范围的情况
            return 1;

        if (exponent == 1)
            return base;

        double temp = 0;
        if ((exponent % 2) == 1) {
            temp = ExponentCount(base, (exponent - 1) / 2);
            temp = temp * temp * base;
        } else {
            temp = ExponentCount(base, exponent / 2);
            temp = temp * temp;
        }
        return temp;
    }

    //使用位运算
    public static double ExponentCount2(double base, int exponent) {
        if(exponent==0)//?考虑int范围的情况
            return 1;

        if (exponent == 1)
            return base;

        double temp = 0;
            temp = ExponentCount2(base, exponent  >>1);
            temp = temp * temp;
            if ((exponent & 1) == 1)
                temp*=base;

        return temp;
    }


    public static void main(String[] args) {
        System.out.println(Power2(2.0,10));
    }
}
