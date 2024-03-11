package com.dsagame.leetcode.dailychallenge.jan;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Leetcode909 {
    public static void main(String[] args) {
        //[[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
        System.out.println(snakesAndLadders(new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        }));

        System.out.println(snakesAndLadders(new int[][]{
                {-1, -1}, {-1, 3}
        }));

        System.out.println(Arrays.deepToString(getCoordinate(1, 6)));
        System.out.println(Arrays.deepToString(getCoordinate(3, 6)));
        System.out.println(Arrays.deepToString(getCoordinate(6, 6)));
        System.out.println(Arrays.deepToString(getCoordinate(7, 6)));
        System.out.println(Arrays.deepToString(getCoordinate(10, 6)));
        System.out.println(Arrays.deepToString(getCoordinate(12, 6)));
        System.out.println(Arrays.deepToString(getCoordinate(13, 6)));
        System.out.println(Arrays.deepToString(getCoordinate(15, 6)));
        System.out.println(Arrays.deepToString(getCoordinate(18, 6)));
        System.out.println(Arrays.deepToString(getCoordinate(19, 6)));
        System.out.println(Arrays.deepToString(getCoordinate(20, 6)));
        System.out.println(Arrays.deepToString(getCoordinate(24, 6)));
        System.out.println(Arrays.deepToString(getCoordinate(25, 6)));
        System.out.println(Arrays.deepToString(getCoordinate(29, 6)));
        System.out.println(Arrays.deepToString(getCoordinate(30, 6)));
        System.out.println(Arrays.deepToString(getCoordinate(31, 6)));

        System.out.println("************");
        System.out.println(Arrays.deepToString(getCoordinate(4, 2)));

    }

    public static int snakesAndLadders(int[][] board) {
        int res = 0;
        Queue<NumAndMovesQueue> queue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[board.length * board.length + 1];
        isVisited[1] = true;
        queue.offer(new NumAndMovesQueue(1, 0));
        while (!queue.isEmpty()) {
            NumAndMovesQueue start = queue.poll();
            if (start.num == board.length * board.length) {
                return start.moves;
            }
            for (int i = 1; i <= 6; i++) {
                if (start.num + i <= board.length * board.length && !isVisited[start.num + i]) {
                    isVisited[start.num + i] = true;
                    int[][] coordinates = getCoordinate(start.num + i, board.length);
                    if (board[coordinates[0][0]][coordinates[0][1]] == -1) {
                        queue.offer(new NumAndMovesQueue(start.num + i, start.moves + 1));
                    } else {
                        queue.offer(new NumAndMovesQueue(board[coordinates[0][0]][coordinates[0][1]], start.moves + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static int[][] getCoordinate(int num, int n) {
        int[][] res = new int[1][2];
        int q = num / n;
        int r = num % n;
        if (q % 2 == 1 && r == 0) {
            res[0][0] = n - q;
            res[0][1] = n - 1;
        } else if (q % 2 == 0 && r == 0) {
            res[0][0] = n - q;
            res[0][1] = r;
        } else if (q % 2 == 0) {
            res[0][0] = n - q - 1;
            res[0][1] = r - 1;
        } else if (q % 2 == 1) {
            res[0][0] = n - q - 1;
            res[0][1] = n - r;
        }
        return res;
    }

}

class NumAndMovesQueue {
    int num;
    int moves;

    public NumAndMovesQueue(int num, int moves) {
        this.num = num;
        this.moves = moves;
    }
}
