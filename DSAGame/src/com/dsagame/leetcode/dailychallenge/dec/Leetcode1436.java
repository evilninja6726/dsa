package com.dsagame.leetcode.dailychallenge.dec;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Leetcode1436 {
    public static void main(String[] args) {
        String input = "[[\"London\",\"New York\"],[\"New York\",\"Lima\"],[\"Lima\",\"Sao Paulo\"]]";

        // Create List<List<String>> from the string representation
        List<List<String>> resultList = Arrays.stream(input.split("\\],\\["))
                .map(s -> s.replaceAll("\\[|\\]", ""))
                .map(s -> Arrays.asList(s.split(",")))
                .collect(Collectors.toList());
        System.out.println(destCity(resultList));
    }

    public static String destCity(List<List<String>> paths) {
        Set<String> set = paths.stream().map(path -> path.get(0)).collect(Collectors.toSet());
        for (List<String> path : paths) {
            if (!set.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}
