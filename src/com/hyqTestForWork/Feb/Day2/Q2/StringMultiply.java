package com.hyqTestForWork.Feb.Day2.Q2;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName StringMultiply
 * @Description TODO  43. 字符串相乘  频度 medium
 * @Author huangyq
 * @Date 2022/2/2 19:52
 * @Version
 **/
public class StringMultiply {
    //思路——模拟竖式乘法，每次去一个进行计算并累加和
    //bug——写清楚步骤，不要把assist和memory用混；  边界——比如第一次计算的求和
    public String multiply(String num1, String num2) {

        if(num1==null||num2==null||num1.length()<1||num2.length()<1){
            return  null;
        }
        if(num1.charAt(0)=='0'||num2.charAt(0)=='0'){
            return "0";
        }
        //辅助数组，存其中一个的值
        int[] num1Value = new int[num1.length()];
        for(int i=0;i<num1.length();i++){
            num1Value[i] = num1.charAt(i)-'0';
        }
        //一个保存累加结果，一个保存当前一轮的计算结果
        Deque<Integer> memory = new LinkedList<>();
        Deque<Integer> assist = new LinkedList<>();
        //记录进位
        int c = 0;
        for(int i=num2.length()-1;i>=0;i--){
            int temp = num2.charAt(i)-'0';
            //计算本轮乘积
            for(int m=num1Value.length-1;m>=0;m--){
                int sum = temp*num1Value[m] + c ;
                c = sum/10;
                int residual = sum%10;
                assist.add(residual);
            }
            if(c!=0){
                assist.add(c);
                c=0;
            }
            //添加 0
            for(int n=num2.length()-1;n>i;n--){
                assist.addFirst(0);
            }
            //累加求和
            if(!memory.isEmpty()){
                int length = memory.size();
                for(int k =0;k<length;k++){
                    Integer add1 = memory.pollFirst();
                    Integer add2 = assist.pollFirst();
                    int tempSum = add1+add2+c;
                    memory.addLast(tempSum%10);
                    c = tempSum/10;
                }
                //超过之前累加和的部分
                while(!assist.isEmpty()){
                    Integer add = assist.pollFirst();
                    memory.addLast((add+c)%10);
                    c = (add+c)/10;
                }
                //最后还有进位遗留
                if(c!=0){
                    memory.add(c);
                    c=0;
                }
            }else{
                while(!assist.isEmpty()) {
                    memory.add(assist.pollFirst());
                }
            }
        }

        StringBuffer strB = new StringBuffer();
        while(!memory.isEmpty()){
            strB.append(memory.pollLast());
        }

        return strB.toString();
    }

    @Test
    public void Test(){
        multiply("123","456");
    }

    //TODO  累乘方式和位数判断
    public String multiply2(String num1, String num2){

        //这种方式可以实现但是代码比较乱
//        int[] memory = new int[num1.length()+num2.length()];
//        int c = 0;
//        int c1 = 0;
//        for(int i=num1.length()-1;i>=0;i--){
//            int multiOne = num1.charAt(i)-'0';
//            int temp = 0;
//            for(int m=num2.length()-1;m>=0;m--){
//                int multiTwo = num2.charAt(m)-'0';
//                int tempSum = multiOne*multiTwo+c ;
//                c = tempSum/10;
//                int residual = tempSum%10;
//                temp = memory[num1.length()-1-i+num2.length()-1-m];
//                memory[num1.length()-1-i+num2.length()-1-m] = (residual + temp+c1)%10;
//                c1 = (residual + temp + c1)/10;
//            }
//            temp = memory[num1.length()-1-i+num2.length()];
//            memory[num1.length()-1-i+num2.length()]
//        }

        //实现1——先计算，算完再累加进位计算
        //bug——把所有进位留在一起处理；  如果先处理一部分要注意本轮乘法后的进位
        int[] memory = new int[num1.length()+num2.length()];
        int c = 0;
        for(int i=num1.length()-1;i>=0;i--){
            int multiOne = num1.charAt(i)-'0';
            for(int m=num2.length()-1;m>=0;m--){
                int multiTwo = num2.charAt(m)-'0';
                int tempSum = multiOne*multiTwo+c ;
                c = tempSum/10;
                int residual = tempSum%10;
                memory[i+m+1] = residual;
            }
            //要注意最后的进位
            memory[i] += c;
            c=0;
        }

        for(int k = memory.length-1;k>0;k--){
            memory[k-1] += memory[k]/10;
            memory[k] = memory[k]%10;
        }

        int index = memory[0]==0?1:0;
        StringBuffer strB = new StringBuffer();
        for(int i=index;i<memory.length;i++){
            strB.append(memory[i]);
        }

        return strB.toString();

        //实现2  一次处理所有进位
//        if(num1==null||num2==null||num1.length()<1||num2.length()<1){
//            return  null;
//        }
//        if(num1.charAt(0)=='0'||num2.charAt(0)=='0'){
//            return "0";
//        }
//        int[] memory = new int[num1.length()+num2.length()];
//        int c = 0;
//        for(int i=num1.length()-1;i>=0;i--){
//            int multiOne = num1.charAt(i)-'0';
//            for(int m=num2.length()-1;m>=0;m--){
//                int multiTwo = num2.charAt(m)-'0';
//                int tempSum = multiOne*multiTwo+c ;
//                memory[i+m+1] += tempSum;
//            }
//        }
//
//        for(int k = memory.length-1;k>0;k--){
//            memory[k-1] += memory[k]/10;
//            memory[k] = memory[k]%10;
//        }
//
//        int index = memory[0]==0?1:0;
//        StringBuffer strB = new StringBuffer();
//        for(int i=index;i<memory.length;i++){
//            strB.append(memory[i]);
//        }
//
//        return strB.toString();
    }
}
