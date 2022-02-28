package com.hyqTestForWork.Janu.Day13.Q4;

/**
 * @ClassName MergeString
 * @Description TODO 415 字符串相加 频度 easy
 * @Author huangyq
 * @Date 2022/1/13 20:54
 * @Version
 **/
public class MergeString {

    //模拟竖式加法运算
    public String addStrings(String num1, String num2) {

        StringBuffer strB = new StringBuffer();
        int temp1 = 0;
        int temp2=0;
        int c = 0;

        int index1 = num1.length()-1;
        int index2 = num2.length()-1;

        while(index1>=0||index2>=0){
            if(index1<0){
                while(index2>=0) {
                    temp2 = num2.charAt(index2) - '0';
                    int sum = temp2 + c;
                    c = sum / 10;
                    strB.append(sum % 10);
                    index2--;
                }
            }else if(index2<0){
                while(index1>=0) {
                    temp1 = num1.charAt(index1) - '0';
                    int sum = temp1 + c;
                    c = sum / 10;
                    strB.append(sum % 10);
                    index1--;
                }
            }else {
                temp1 = num1.charAt(index1) - '0';
                temp2 = num2.charAt(index2) - '0';

                int sum = temp1 + temp2 + c;
                c = sum / 10;
                strB.append(sum % 10);
                index1--;
                index2--;
            }
        }

        if(c>0) strB.append(c);
        strB.reverse();
        return strB.toString();
    }
}
