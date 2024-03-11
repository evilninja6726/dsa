package com.dsagame.leetcode.graphs.medium;

public class Leetcode130 {
    public static void main(String[] args) {
        char[][] grid = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(grid);
        for (char[] chars : grid) {
            System.out.println(chars);
        }
    }

    public static void solve(char[][] board) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            helper(board, i, 0, isVisited);
            helper(board, i, board[0].length - 1, isVisited);
        }
        for (int j = 0; j < board[0].length; j++) {
            helper(board, 0, j, isVisited);
            helper(board, board.length - 1, j, isVisited);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && !isVisited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void helper(char[][] board, int row, int column, boolean[][] isVisited) {
        if (row < 0 || column < 0 || row >= board.length || column >= board[0].length || board[row][column] == 'X' || isVisited[row][column]) {
            return;
        }
        isVisited[row][column] = true;
        for (int[] direction : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
            helper(board, row + direction[0], column + direction[1], isVisited);
        }
    }
}
