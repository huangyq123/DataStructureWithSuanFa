package com.hyqTestForWork.Janu.Day24.Q3;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ValidSpase
 * @Description TODO  22. 括号生成  频度 medium
 * @Author huangyq
 * @Date 2022/1/24 20:55
 * @Version
 **/
public class ValidSpase {

    //注意中间变量tremp和结果的存储结构result，避免浅拷贝
    public List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        dfs(n,n,temp,result);

        return result;
    }

    public void dfs(int leftResidual,int rightResidual,List<String> temp,List<String> result){

        if(leftResidual==0&&rightResidual==0){
            StringBuffer strBuffer = new StringBuffer();
            for(int i=0;i<temp.size();i++){
                String s = temp.get(i);
                strBuffer.append(s);
            }
            String str = strBuffer.toString();
            result.add(str);
            return ;
        }

        if(leftResidual>0){
            temp.add("(");
            dfs(leftResidual-1,rightResidual,temp,result);
            temp.remove(temp.size()-1);
        }

        if(rightResidual>0&&rightResidual>leftResidual){
            temp.add(")");
            dfs(leftResidual,rightResidual-1,temp,result);
            temp.remove(temp.size()-1);
        }

    }
}
