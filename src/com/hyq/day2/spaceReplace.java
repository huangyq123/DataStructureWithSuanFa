package com.hyq.day2;

/**
 * @ClassName spaceReplace
 * @Description TODO  替换字符串中的空格
 * @Author huangyq
 * @Date 2021/2/25 15:32
 * @Version
 **/
public class spaceReplace {

    public static void main(String[] args) {
        String str = null;
        StringBuffer strb = stringReplace(str);
        System.out.println(strb);
    }

/**
 *@Author huangyq
 *@Description TODO  替换字符串空格,用新建字符串的方式实现
 *                   问题：未考虑空字符串等边界条件
 *@Date 2021/2/25 15:46
 *@Param [str]
 *@return java.lang.StringBuffer
 *@Version
 **/
    public static StringBuffer stringReplace(String str){

        if(str==null)
            return null;//注意边界条件

        StringBuffer s = new StringBuffer();//赋值方式？
        //char[] c = new char[str.length()];
        char c = 0;
        for(int i=0;i<str.length();i++){
            c =str.charAt(i);
            if(c==' ')
                s.append("%20");
            else
                s.append(c);
        }
        return s;
    }

//    public static String stringReplace2(String str){
//String.valueOf()
//    }

}
