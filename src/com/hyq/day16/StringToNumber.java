package com.hyq.day16;

/**
 * @ClassName StringToNumber
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/15 7:33
 * @Version
 **/
public class StringToNumber {


    public static int strToInt(String str) {
        if (str == null)
            return 0;

        char[] temp = str.toCharArray();
        int index = 0;
        StringBuffer strB = new StringBuffer();
        while (index < temp.length) {
            if (strB.length() == 0 && temp[index] == ' ') {
                index++;
                continue;
            }

            if (strB.length() == 0 && (temp[index] < 48 || temp[index] > 57) && temp[index] != '+' && temp[index] != '-')
                break;

            if (strB.length() == 0) {
                strB.append(temp[index++]);
                continue;
            }

            if (strB.length() >= 1) {
                if (temp[index] >= 48 && temp[index] <= 57)
                    strB.append(temp[index++]);
                else
                    break;
            }
        }

        if (strB.length() == 0)
            return 0;
        else if (strB.length() == 1 && (strB.charAt(0) == '+' || strB.charAt(0) == '-'))
            return 0;
        else if (strB.length() == 1)
            return Integer.parseInt(strB.toString());
        else {
            String s = null;
            if (strB.charAt(0) == '+' || strB.charAt(0) == '-' || strB.charAt(0) == '0') {
                int start = 1;
                while (start < strB.length()) {
                    if (strB.charAt(start) != '0')
                        break;
                    start++;
                }
                if (strB.charAt(0) == '0')
                    s = strB.substring(start, strB.length());
                else
                    s = strB.substring(0, 1) + strB.substring(start, strB.length());
            } else
                s = strB.toString();

            if (s.length() == 0)
                return 0;
            else if (s.length() == 1 && (s.charAt(0) == '+' || strB.charAt(0) == '-'))
                return 0;
            else {
                if (s.charAt(0) == '-') {
                    long l = Long.parseLong(s.substring(1, s.length()));
                    if ( l*(-1) < Integer.MIN_VALUE)
                        return Integer.MIN_VALUE;
                    else
                        return ((int) l) * (-1);
                } else {
                    long l = 0;
                    if (s.charAt(0) == '+')
                        l = Long.parseLong(s.substring(1, s.length()));
                    else
                        l = Long.parseLong(s);
                    if (l > Integer.MAX_VALUE)
                        return Integer.MAX_VALUE;
                    else
                        return (int) l;
                }
            }
        }
    }

    public static void main(String[] args) {
        int i = strToInt("-91283472332");
        System.out.println(i);
    }
}

