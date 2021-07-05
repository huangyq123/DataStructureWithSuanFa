package com.hyq.leetcode.UnionFind.question1;

/**
 * @ClassName UnionArea
 * @Description TODO
 * @Author huangyq
 * @Date 2021/4/15 15:49
 * @Version
 **/
public class UnionArea {

    public static void main(String[] args) {
        solve(new char[][]{{'O', 'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X', 'O'}, {'X', 'O', 'X', 'O', 'X'}, {'O', 'X', 'O', 'O', 'O'}, {'X', 'X', 'O', 'X', 'O'}});
    }

    //遍历思路_问题：查找连接性的方式不正确
    public static void solve(char[][] board) {
        int row = board.length;
        int column = board[0].length;

        for (int k = 0; k < column; k++) {
            if (board[0][k] == 'O') board[0][k] = '#';
            if (board[row - 1][k] == 'O') board[row - 1][k] = '#';
        }

        for (int k = 0; k < row; k++) {
            if (board[k][0] == 'O') board[k][0] = '#';
            if (board[k][column - 1] == 'O') board[k][column - 1] = '#';
        }

        int left = 1;
        int up = 1;
        int right = column-2;
        int down = row-2;

        while (up<=down&&left<=right){
            for (int i = up; i <=down; i++) {
                for (int j = left; j <=down; j++) {
                    if (board[i][j] == 'O') {
                        if (board[i - 1][j] == '#' || board[i][j - 1] == '#' || board[i][j + 1] == '#' || board[i + 1][j] == '#')
                            board[i][j] = '#';
                    }
                }
            }
            up++;
            down--;
            left++;
            right--;
        }


        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < column - 1; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
        char temp = 'a';
        System.out.println(1);
    }
}
