package com.laioffer.Driver;

public class Solution {
    public void solve(char[][] board) {
        // Corner case
        if (board == null || board.length <= 1) {
            return;
        }
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (!isVisited[row][col]) {
                    DFS(board, isVisited, row, col);
                }
            }
        }
    }

    public void DFS(char[][] board, boolean[][] isVisited, int row, int col) {
        // terminate condition
        if (row > board.length || row < 0 || col > board.length || col < 0 || isVisited[row][col]) {
            return;
        }
        // Expanding Rule
        if(board[row][col]=='X'){
            isVisited[row][col] = true;
            return;
        }
        // check if the o is around by x
        if(row==0 || row==board.length || col==0 || col==board[0].length){
            isVisited[row][col] = true;
        }

    }
}
