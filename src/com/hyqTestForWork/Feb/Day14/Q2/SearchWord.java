package com.hyqTestForWork.Feb.Day14.Q2;

import org.junit.Test;

/**
 * @ClassName SearchWord
 * @Description TODO  79. 单词搜索  频度 medium
 * @Author huangyq
 * @Date 2022/2/14 20:43
 * @Version
 **/
public class SearchWord {
    //回溯——经典回溯法
    //注意：什么时候退出循环，怎么退出循环（这里有两层，直接返回，否则应该退出两层循环）
    public boolean exist(char[][] board, String word) {
        boolean result = false;
        int[][] flag = new int[board.length][board[0].length];
        for(int m=0;m<board.length;m++){
            for(int n=0;n<board[0].length;n++) {
                 result = dfs(board, word, 0, m, n, flag);
                 if(result){
                    return result;
                 }
            }
        }

        return result;
    }

    public boolean dfs(char[][] board,String word,int index,int row,int column,int[][] flag){

        if(index==word.length()){
            return true;
        }
        if(row<0||column<0||row>=board.length||column>=board[0].length){
            return false;
        }
        if(flag[row][column]==1){
            return false;
        }

        char c = word.charAt(index);
        if(c==board[row][column]){
            flag[row][column] = 1;
            boolean result = false;
            result = dfs(board, word, index + 1, row - 1, column, flag);
            if(result){
                return true;
            }
            result = dfs(board, word, index + 1, row + 1, column, flag);
            if(result){
                return true;
            }
            result = dfs(board, word, index + 1, row , column-1, flag);
            if(result){
                return true;
            }
            result = dfs(board, word, index + 1, row , column+1, flag);
            if(result){
                return true;
            }

            flag[row][column] = 0;
            return false;
        }else {
            return false;
        }
    }

    @Test
    public void Test(){
        char[][] test = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        exist(test,"ABCCED");
    }


    //TODO  递归代码重复代码优化——数组方式
}
