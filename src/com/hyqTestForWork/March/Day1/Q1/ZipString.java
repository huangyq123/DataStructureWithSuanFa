package com.hyqTestForWork.March.Day1.Q1;

/**
 * @ClassName ZipString
 * @Description TODO  443. 压缩字符串  medium
 * @Author huangyq
 * @Date 2022/3/1 15:45
 * @Version
 **/
public class ZipString {
    public int compress(char[] chars) {

        if(chars==null){
            return 0;
        }
        if(chars.length==1){
            return 1;
        }

        //分别用 pre 记录已经做完的记录的尾部（必定要是字符char）， current记录还未处理的剩余部分的头部
        int current = 1;
        int pre = 0;
        int count = 1;
        while(current<chars.length){
            // 下一个处理的依然是相同char
            if(chars[current]==chars[pre]){
                current++;
                count+=1;
                continue;
            }
            //不是相同char，且只有一个字符，没有重复字符；
            if(count==1){
                //记录新字符
                pre++;
                chars[pre] = chars[current];
                //找下一个未处理的新字符
                current++;
                count=1;
                continue;
            }

            //不是相同字符，且有重复——记录个数并更新数组；
            pre = getPre(chars, pre, count);
            //获取下一个需要处理的字符
            pre++;
            chars[pre] = chars[current];
            current++;
            count=1;

        }

        if(count!=1){
            pre = getPre(chars,pre,count);
        }

        return pre+1;
    }

    private int getPre(char[] chars, int pre, int count) {
        String tempValue = Integer.toString(count);
        int index=0;
        while(index<tempValue.length()){
            chars[pre +index+1] = tempValue.charAt(index);
            index++;
        }
        pre = pre+index;
        return pre;
    }
}
