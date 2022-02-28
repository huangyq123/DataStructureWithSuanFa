package com.hyqTestForWork.Feb.Day6.Q1;

import org.junit.Test;

/**
 * @ClassName IsIP
 * @Description TODO  468. 验证IP地址 频度 medium
 * @Author huangyq
 * @Date 2022/2/6 15:20
 * @Version
 **/
public class IsIP {
    //思路没问题，就是细节\边界没有考虑清楚导致改了几次
    //  这种题注意细节，最好在一开始就把一些特殊边界去掉——  split分隔符在首尾；  字符串长度查过int范围；   16进制可以使用的字符
    public String validIPAddress(String queryIP) {

        if(queryIP==null||(queryIP.contains(".")&&queryIP.contains(":"))){
            return "Neither";
        }
        if(queryIP.startsWith(".")||queryIP.endsWith(".")||queryIP.startsWith(":")||queryIP.endsWith(":")){
            return "Neither";
        }
        if(queryIP.length()>39||queryIP.length()<7){
            return "Neither";
        }

        if(queryIP.contains(".")){

            String[] splitIPV4 = queryIP.split("[.]");
            if(splitIPV4.length!=4){
                return "Neither";
            }

            for(int i=0;i<splitIPV4.length;i++){
                String temp = splitIPV4[i];
                if("".equals(temp)){
                    return "Neither";
                }else {
                    for(int k=0;k<temp.length();k++){
                        char c = temp.charAt(k);
                        if(!(c>='0'&&c<='9')){
                            return "Neither";
                        }
                    }

                    int value = Integer.parseInt(temp);
                    if(value==0&&temp.length()>1){
                        return "Neither";
                    }else if(value>255){
                        return "Neither";
                    }else if(value!=0&&temp.charAt(0)=='0'){
                        return "Neither";
                    }
                }
            }
            return "IPv4";

        }else if(queryIP.contains(":")){
            String[] splitIPV6 = queryIP.split("\\:");
            if(splitIPV6.length!=8){
                return "Neither";
            }

            for(int i=0;i<splitIPV6.length;i++){
                String temp = splitIPV6[i];
                if("".equals(temp)){
                    return "Neither";
                }else if (temp.length()>4){
                    return "Neither";
                }else{
                    for(int k=0;k<temp.length();k++){
                        char c = temp.charAt(k);
                        if((c>='g'&&c<='z')||(c>='G'&&c<='Z')){
                            return "Neither";
                        }
                    }
                }
            }
            return "IPv6";
        }else{
            return "Neither";
        }


    }

    @Test
    public void Test(){
        validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334");
    }
}
