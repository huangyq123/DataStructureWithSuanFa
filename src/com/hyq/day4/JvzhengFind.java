package com.hyq.day4;

import java.util.Arrays;

/**
 * @ClassName JvzhengFind
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/1 10:25
 * @Version
 **/
public class JvzhengFind {


    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
//        char[][] board = new char[][]{{'A', 'B'}, {'C', 'D',}};
//        String word = "ABCD";
        boolean exist = exist(board, word);
        System.out.println(exist);
    }

    //解法错误，未回溯
    public static boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0 || board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        //第一个字母处理
        int k = 0;
        int[] position = new int[]{0, 0};
        char c1 = word.charAt(k);
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int m = 0; m < board[0].length; m++) {
                if (c1 == board[i][m]) {
                    position[0] = i;
                    position[1] = m;

                    char[][] newc = new char[board.length][board[0].length];
                    for (int t = 0; t < board.length; t++)
                        newc[t] = Arrays.copyOf(board[t], board[t].length);

                    newc[position[0]][position[1]] = '0';

                    flag = true;
                    flag = findNext(newc, position, word, flag);
                    if (flag)
                        break;
                }
            }
            if (flag)
                break;
        }
        //无首字母
//        if (!flag)
//            return false;

        return flag;
    }

    public static boolean findNext(char[][] board, int[] position, String word, boolean flag) {
        int number = 1;//第number个字符
        while (number < word.length()) {
            boolean[] result = new boolean[]{false, false, false, false};
            //剩余字母处理
            if (position[1] > 0) {
                result[0] = findAssist(board, position[0], position[1] - 1, word.charAt(number));
            }
            if (!result[0] && position[1] < board[0].length - 1) {
                result[1] = findAssist(board, position[0], position[1] + 1, word.charAt(number));
            }
            if (!result[1] && position[0] > 0) {
                result[2] = findAssist(board, position[0] - 1, position[1], word.charAt(number));
            }
            if (!result[2] && position[0] < board.length - 1) {
                result[3] = findAssist(board, position[0] + 1, position[1], word.charAt(number));
            }

            if (!result[0] && !result[1] && !result[2] && !result[3]) {
                flag = false;
                break;
            } else {
                if (result[0])
                    position[1] -= 1;
                else if (result[1])
                    position[1] += 1;
                else if (result[2])
                    position[0] -= 1;
                else if (result[3])
                    position[0] += 1;
            }
            board[position[0]][position[1]] = '0';
            flag = true;
            number += 1;
        }
        return flag;
    }


    public static boolean findAssist(char[][] board, int row, int column, char target) {
        boolean flag = false;
        if (board[row][column] == target) {
            flag = true;
        }
        return flag;
    }


    //DFS实现
    public static boolean DfsFind(char[][] board, String word){
        int k = 0;
        boolean flag = false;
        for(int m =0;m<board.length;m++){
            for(int n=0;n<board[0].length;n++){
                if(DFS(board,m,n,word,k)){
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }
        return flag;
    }

    public static boolean DFS(char[][] board,int m,int n,String word,int k){
        //终止条件
        if(m<0||n<0||m>board.length-1||n>board[0].length-1||board[m][n]!=word.charAt(k))
            return false;
        //结束条件
        if(k==word.length()-1)
            return true;

        //轨迹记录
        boolean flag = false;//信息记录
        char temp = board[m][n];
        board[m][n]='0';
        //方向搜寻
        if(DFS(board,m-1,n,word,k+1)||DFS(board,m+1,n,word,k+1)||DFS(board,m,n-1,word,k+1)||DFS(board,m,n+1,word,k+1)){
            flag = true;
        }
        board[m][n]=temp;
        return flag;

    }
}
