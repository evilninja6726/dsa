package com.dsagame.leetcode.graphs.hard;

import java.util.*;

public class Leetcode773 {
    public static void main(String[] args) {
        System.out.println(slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}}));
        System.out.println(slidingPuzzle(new int[][]{{1, 2, 3}, {5, 4, 0}}));
        System.out.println(slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}}));
    }

    public static int slidingPuzzle(int[][] board) {
        StringBuilder currBoard = new StringBuilder();
        Arrays.stream(board).flatMapToInt(Arrays::stream).forEach(currBoard::append);
        if (currBoard.toString().equals("123450")) {
            return 0;
        }
        Queue<State> queue = new ArrayDeque<>();
        Set<String> states = new HashSet<>();
        queue.offer(new State(currBoard.indexOf("0"), currBoard.toString(), 0));
        states.add(currBoard.toString());
        int res = 0;
        while (!queue.isEmpty()) {
            State front = queue.poll();
            if (front.board.equals("123450")) {
                return res;
            }
            res = front.moves;
            int[][] swap = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
            for (int x : swap[front.zeroIndex]) {
                StringBuilder newBoard = new StringBuilder(front.board);
                char temp = newBoard.charAt(front.zeroIndex);
                newBoard.setCharAt(front.zeroIndex, newBoard.charAt(x));
                newBoard.setCharAt(x, temp);
                if (!states.contains(newBoard.toString())) {
                    states.add(newBoard.toString());
                    queue.offer(new State(x, newBoard.toString(), front.moves + 1));
                }
            }
        }
        return -1;
    }


    private static class State {
        int zeroIndex;
        String board;
        int moves;

        public State(int zeroIndex, String board, int moves) {
            this.zeroIndex = zeroIndex;
            this.board = board;
            this.moves = moves;
        }
    }
}
