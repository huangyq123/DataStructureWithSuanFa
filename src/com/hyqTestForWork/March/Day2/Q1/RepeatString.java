package com.hyqTestForWork.March.Day2.Q1;


/**
 *@Author admin
 *@Description TODO 459. 重复的子字符串  easy
 *@Date 2022/3/2 18:33
 *@Param
 *@return
 *@Version
 **/

public class RepeatString {
    //注意边界——比如奇数长度使用偶数长的前缀，因此先判断是否除尽；
    //可以优化——对每一个字符，按照前缀长度比较前一字符和后一字符，不用进行一次把所有匹配位置进行比较（代码逻辑简单一些）
    public boolean repeatedSubstringPattern(String s) {

        boolean result = false;
        //以这个长度作为前缀进行匹配
        for(int i=0;i<s.length()/2;i++){
            //注意前提条件——可以被除尽
            if(s.length()%(i+1)!=0){
                continue;
            }

            int length = i+1;
            boolean currentTemp = true;
            //取前缀每一个字符
            for(int k=0;k<length;k++) {
                boolean temp = true;
                //进行比较，把每一个字符需要进行的匹配都进行比较
                for (int m = k; m < s.length() - length; ) {
                    if (s.charAt(m) == s.charAt(m + length)) {
                        m += length;
                    } else {
                        temp = false;
                        break;
                    }
                }
                //提前退出，说明存在不匹配
                if(!temp){
                    currentTemp=false;
                    break;
                }
            }
            //如果是正常结束，说明匹配
            if(currentTemp){
                return true;
            }
        }

        return false;
    }

    //TODO  使用子串存在原理
    public boolean repeatedSubstringPattern2(String s){
        StringBuilder str = new StringBuilder(s+s);
        String newString = str.substring(1,str.length()-1);

        return newString.contains(s);
    }
}
