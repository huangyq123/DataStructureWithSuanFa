package com.hyq.day11;

/**
 * @ClassName NumberOfOne
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/9 14:00
 * @Version
 **/
public class NumberOfOne {

//效率低，超时
    public int countDigitOne(int n) {

        int count =0;
        for(int i=1;i<=n;i++){
            String temp = Integer.toString(i);
            for(int k =0;k<temp.length();k++){
                if('1'==temp.charAt(k))
                    count++;
            }
        }
        return count;
    }

    //
    public static int countDigitOne2(int n){
        if(n<1)
            return 0;
        return Recur(n);
    }


    public static int Recur(int number){
        int count =0;            //统计
        int length = 1;                        //计算位数
        while(number>=((int) Math.pow(10,length))){
            length++;
        }

        if(length==1){       //递归结束条件
            if(number<1)
                return 0;
            else
                return 1;
        }

        int assist = (int) Math.pow(10,length-1);         //取余对象
        int leftNumber = number%assist;                   //截短

        if(number/assist>1){            //包含所有最高位的1,最高位和剩余位分别计算
            count=assist+number/assist*(length-1)*((int) Math.pow(10,length-2));
        }else{                   //不包含所有最高位的1
            count=leftNumber+1+number/assist*(length-1)*((int) Math.pow(10,length-2));
        }

        count=count+Recur(leftNumber);
        return count;
    }


    public static void main(String[] args) {
      int  result = countDigitOne2(10);
        System.out.println(result);
    }
}
