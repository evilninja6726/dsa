package com.dsagame.striver.graph;

import java.util.*;

public class WordLadderI {
    public static void main(String[] args) {
        // Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
        System.out.println(ladderLength("hit", "cog", new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log", "cog"))));
        System.out.println(ladderLength("hit", "cog", new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log"))));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(beginWord, 1));
        while (!queue.isEmpty()) {
            Pair front = queue.poll();
            if (front.word.equals(endWord)) {
                return front.sequence;
            }
            for (int i = 0; i < front.word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != front.word.charAt(i)) {
                        StringBuilder s = new StringBuilder(front.word);
                        s.setCharAt(i, c);
                        if (set.contains(s.toString())) {
                            set.remove(s.toString());
                            queue.offer(new Pair(s.toString(), front.sequence + 1));
                        }
                    }
                }
            }
        }
        return 0;
    }

    private static class Pair {
        String word;
        int sequence;

        Pair(String word, int sequence) {
            this.word = word;
            this.sequence = sequence;
        }
    }
}
