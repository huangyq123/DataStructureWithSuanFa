package com.hyqTestForWork.Janu.Day24.Q1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ReturnIP
 * @Description TODO 93. 复原 IP 地址  频度 medium
 * @Author huangyq
 * @Date 2022/1/24 19:42
 * @Version
 **/
public class ReturnIP {
    //这个题就记这个方法就是了
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s==null||s.length()<4||s.length()>12){
            return result;
        }

        String[] memory = new String[4];

        find(result,s,memory,0,0);

        return result;
    }

    public void find(List<String> result,String s,String[] memory,int index,int count){
        if(count==3){
            if(index>=s.length()){
                return ;
            }else if(index<s.length()-3){
                return ;
            }else{
                //判断情况要理清楚，不能缺少
                memory[count] = s.substring(index,s.length());
                StringBuffer strBuffer = new StringBuffer();
                for(int m=0;m<4;m++){
                    String temp = memory[m];
                    if(temp.length()==2&&temp.startsWith("0")){
                        return ;
                    }else if(temp.length()==3&&temp.startsWith("0")){
                        return ;
                    }else if(temp.length()==3){
                        if(temp.charAt(0)>'2'){
                            return ;
                        }else if(temp.charAt(0)=='2'&&temp.charAt(1)>'5'){
                            return ;
                        }else if(temp.charAt(0)=='2'&&temp.charAt(1)=='5'&&temp.charAt(2)>'5'){
                            return ;
                        }else{
                            strBuffer.append(temp+".");
                        }
                    }else if(temp.length()==2||temp.length()==1){
                        strBuffer.append(temp+".");
                    }
                }
                strBuffer.delete(strBuffer.length()-1,strBuffer.length());
                String s1 = strBuffer.toString();
                result.add(s1);
                memory[3] = "";
                return ;
            }
        }

        if(index>=s.length()){
            return ;
        }


        for(int i=1;i<4;i++){
            //这里注意一个边界考虑,否则会出现越界问题
            if(index+i>s.length()){
                return ;
            }
            String substring = s.substring(index, index + i);
            memory[count] = substring;
            find(result,s,memory,index+i,count+1);
            memory[count] = "";
        }

    }

    @Test
    public void Test(){
        String test = "0000";

        restoreIpAddresses(test);
    }
}
