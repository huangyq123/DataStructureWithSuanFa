package com.hyq.day6;

/**
 * @ClassName numberString
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/3 11:02
 * @Version
 **/
public class numberString {
    public static void main(String[] args) {
        boolean result = isNumber("-1E-16");
        System.out.println(result);
    }

    public static boolean isNumber(String s) {
        if (s == null)
            return false;

        int status = 1;
        char readerChar = ' ';
        int position = 0;

        while (position < s.length()&&status<11) {
            readerChar = s.charAt(position);
            if (status == 1) {
                if (readerChar == ' ')
                    status = 1;
                else if (readerChar == '+' || readerChar == '-')
                    status = 2;
                else if (readerChar == '.')
                    status = 5;
                else if (readerChar >= '0' && readerChar <= '9')
                    status = 3;
                else
                    status = 11;
            } else if (status == 2) {
                if (readerChar == '.')
                    status = 5;
                else if (readerChar >= '0' && readerChar <= '9')
                    status = 3;
                else
                    status = 11;
            } else if (status == 3) {
                if (readerChar == ' ')
                    status = 10;
                else if (readerChar == 'e'||readerChar=='E')
                    status = 7;
                else if (readerChar == '.')
                    status = 4;
                else if (readerChar >= '0' && readerChar <= '9')
                    status = 3;
                else
                    status = 11;
            } else if (status == 4) {
                if (readerChar == ' ')
                    status = 10;
                else if (readerChar == 'e'||readerChar=='E')
                    status = 7;
                else if (readerChar >= '0' && readerChar <= '9')
                    status = 6;
                else
                    status = 11;
            } else if (status == 5) {
                if (readerChar >= '0' && readerChar <= '9')
                    status = 6;
                else
                    status = 11;
            } else if (status == 6) {
                if (readerChar == ' ')
                    status = 10;
                else if (readerChar == 'e'||readerChar=='E')
                    status = 7;
                else if (readerChar >= '0' && readerChar <= '9')
                    status = 6;
                else
                    status = 11;
            } else if (status == 7) {
                if (readerChar == '+' || readerChar == '-')
                    status = 8;
                else if (readerChar >= '0' && readerChar <= '9')
                    status = 9;
                else
                    status = 11;
            }else if(status == 8){
                if(readerChar>='0'&&readerChar<='9')
                    status = 9;
                else
                    status = 11;
            }else if(status == 9){
                if(readerChar==' ')
                    status = 10;
                else if(readerChar>='0'&&readerChar<='9')
                    status = 9;
                else
                    status = 11;
            }else if(status == 10){
                if(readerChar==' ')
                    status = 10;
                else
                    status = 11;
            }
            position++;
        }
        if(status==3||status==4||status==6||status==9||status==10)
            return true;
        else
            return false;
    }
}
