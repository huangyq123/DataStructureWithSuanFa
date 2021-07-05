package com.hyq.leetcode2.june.eight;

/**
 * @ClassName randomImplement
 * @Description TODO
 * @Author huangyq
 * @Date 2021/6/8 19:08
 * @Version
 **/
public class RandomImplement {

    public static int rand7(){

        int result = ((int) Math.random() * 7) + 1;
        return result;
    }

    public static  int rand10() {
//        int temp1 = rand7();
//        int temp2 = rand7()%4;
//        int temp3 = rand7()%2;


        int temp1=rand7();
        int temp2=rand7();

        //两个数49中组合，取40种，平分概率
        while(temp1>6||(temp1>5&&temp2>5)){
            temp1=rand7();
            temp2=rand7();
        }

        //将结果均匀分布到1-10中
       int result = ((temp1-1)*7+temp2)%10+1;
        return result;
    }
}
