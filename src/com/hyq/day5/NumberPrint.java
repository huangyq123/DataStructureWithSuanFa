package com.hyq.day5;

/**
 * @ClassName NumberPrint
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/2 10:51
 * @Version
 **/
public class NumberPrint {

    public static void main(String[] args) {
//        int[] result = PrintNumber(3);
//        PrintArray(result);

//        int m = 5;
//        char c = (char) (m+'0');
//        System.out.println(c);


        for(String s :PrintNumber2(2))

            System.out.println(s);
    }

    //问题：范围问题，无法处理大数越界
    public static int[] PrintNumber(int n) {
        int[] result = new int[((int) Math.pow(10, n) - 1)];
        for (int i = 0; i < result.length; i++)
            result[i] = i + 1;

        return result;
    }

    public static void PrintArray(int[] a) {
        for (int m = 0; m < a.length; m++)
            System.out.println(a[m]);
    }


//根本问题：变量类型不足以存储数——使用其他类型存储
    //实现问题：char类型转换；String 赋值；String 方法
    public static String[] PrintNumber2(int n) {
        String str = new  String();
        char[] c = new char[n];
        for (int i = 0; i < 10; i++) {
            c[0] = (char) (i+'0');
            str =AddNumber(str,c, 1);
        }
        str = str.substring(2);
        return str.split(",");
    }

    public static String AddNumber(String str,char[] c, int position) {
        if (position == c.length) {
            int location = Count(c);
            String strTemp = new String(c);
            str+=strTemp.substring(location,c.length);
            str+=",";
            return str;
        }


        if (position < c.length) {
            for (int m = 0; m < 10; m++) {
                c[position] = (char) (m+'0');
                str = AddNumber(str,c, position + 1);
            }
        }
        return str;
    }

    public static int Count(char[] c) {
        int temp = c.length-1;
        for (int k = 0; k < c.length; k++)
            if (c[k] != '0') {
                temp = k;
                break;
            }
        return temp;
    }


}
