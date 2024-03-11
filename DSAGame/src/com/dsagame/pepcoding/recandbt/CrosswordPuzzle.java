package com.dsagame.pepcoding.recandbt;

import java.util.Arrays;

public class CrosswordPuzzle {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
                {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
                {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
                {'+', '-', '-', '-', '-', '-', '+', '+', '+', '+'},
                {'+', '-', '+', '+', '+', '-', '+', '+', '+', '+'},
                {'+', '-', '+', '+', '+', '-', '+', '+', '+', '+'},
                {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
                {'+', '+', '-', '-', '-', '-', '-', '-', '+', '+'},
                {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
                {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'}
        };

        String[] words = new String[]{"LONDON", "DELHI", "ICELAND", "ANKARA"};
        crosswordPuzzle(words, board, 10, 10);
    }

    public static void crosswordPuzzle(String[] words, char[][] board, int m, int n) {
        helper(words, 0, board);
    }

    public static void helper(String[] words, int currWordPosition, char[][] board) {
        if (currWordPosition == words.length) {
            for (char[] chars : board) {
                System.out.println(Arrays.toString(chars));
            }
            return;
        }
        String currWord = words[currWordPosition];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-' || board[i][j] == currWord.charAt(0)) {
                    if (isPossibleToPutHorizontally(currWord, i, j, board)) {
                        StringBuilder old = new StringBuilder();
                        for (int k = 0; k < currWord.length(); k++) {
                            old.append(board[i][k + j]);
                            board[i][k + j] = currWord.charAt(k);
                        }
                        helper(words, currWordPosition + 1, board);
                        for (int k = 0; k < old.length(); k++) {
                            board[i][k + j] = old.charAt(k);
                        }
                    }
                    if (isPossibleToPutVertically(currWord, i, j, board)) {
                        StringBuilder old = new StringBuilder();
                        for (int k = 0; k < currWord.length(); k++) {
                            old.append(board[k + i][j]);
                            board[k + i][j] = currWord.charAt(k);
                        }
                        helper(words, currWordPosition + 1, board);
                        for (int k = 0; k < old.length(); k++) {
                            board[k + i][j] = old.charAt(k);
                        }
                    }
                }
            }
        }
    }

    public static boolean isPossibleToPutHorizontally(String word, int i, int j, char[][] board) {
        if (j != 0 && board[i][j - 1] != '+') {
            return false;
        }
        for (int k = 0; k < word.length(); k++) {
            if (j == board[i].length) {
                return false;
            }
            if (board[i][j] == '+' || (board[i][j] != word.charAt(k) && board[i][j] != '-')) {
                return false;
            }
            j++;
        }
        return j == board[i].length || board[i][j] == '+';
    }

    public static boolean isPossibleToPutVertically(String word, int i, int j, char[][] board) {
        if (i != 0 && board[i - 1][j] != '+') {
            return false;
        }
        for (int k = 0; k < word.length(); k++) {
            if (i == board.length) {
                return false;
            }
            if (board[i][j] == '+' || (board[i][j] != word.charAt(k) && board[i][j] != '-')) {
                return false;
            }
            i++;
        }

        return i == board.length || board[i][j] == '+';
    }
}
