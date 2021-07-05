package com.hyq.day12;

/**
 * @ClassName LongestSubString
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/10 19:11
 * @Version
 **/
public class LongestSubString {
//双指针法
    public int lengthOfLongestSubstring(String s){
        if(s==null||s.length()==0)//边界处理
            return 0;
        if(s.length()==1)
            return 1;

        int count = 1;              //串长度至少为2
        int point1 = 0;          //字串起始位置
        int point2 = 1;          //下一个要增加到子串中的字符的位置
        int max = 1;              //最大长度
        while(point2<s.length()){   //是否查找到串末尾
            if(!s.substring(point1,point2).contains(s.substring(point2,point2+1))){   //已找到的子串中不含有当前增加的字符
                point2++;                         //尾指针指向下一位
                count++;                          //串长度+1
            }
            else {             //找到重复字符
                max = Math.max(max,count);            //更新最大长度
                while(s.charAt(point1)!=s.charAt(point2)){         //开始缩小左边界知道point1-point2中不包含重复字符
                    point1++;           //未找到重复字符位置， 缩小一位
                    count--;           //每缩小一位，字串长度-1；
                }
                point1++;       //找到重复字符位置，头指针左移一位使子串不包含重复字符
                point2++;         //原来的重复字符变成不重复，添加到子串中
            }
        }

        max = Math.max(max,count);
        return max;
    }
}
