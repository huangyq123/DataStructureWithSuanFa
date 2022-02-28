package com.hyqTestForWork.Janu.Day29.Q2;

/**
 * @ClassName rand7Torand10
 * @Description TODO  470. 用 Rand7() 实现 Rand10() 频度 medium
 * @Author huangyq
 * @Date 2022/1/29 19:03
 * @Version
 **/
public class rand7Torand10 {
    //不会——题解
    // 核心：保证数的概率相同，理由得到的数来进行与1-10的对应   问题：如何构造规则？？
    //  https://leetcode-cn.com/problems/implement-rand10-using-rand7/solution/mo-neng-gou-zao-fa-du-li-sui-ji-shi-jian-9xpz/
//    public int rand10(){
//
//        int first = -1;
//        int second = -1;
//
//        while(true){
//            first = rand7();
//            if(first<7){
//                break;
//            }else{
//                first=-1;
//            }
//        }
//
//        while(true){
//            second = rand7();
//            if(second<6){
//                break;
//            }else{
//                second=-1;
//            }
//        }
//
//        return (first%1)==1?second:5+second;
//
//    }
}
