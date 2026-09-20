package com.leetcode.practice._451_Sort_Characters_By_Frequency;

import java.util.*;

public class Solution {
    public static String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (Character ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        List<Character>[] buckerArr = new List[s.length() + 1];

        for (var e : freqMap.entrySet()) {
            if (buckerArr[e.getValue()] == null) {
                buckerArr[e.getValue()] = new ArrayList<>();
            }
            buckerArr[e.getValue()].add(e.getKey());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i >= 0; i--) {
            if (buckerArr[i] == null) continue;
            for (var e : buckerArr[i]) {
                sb.append(String.valueOf(e).repeat(i));
            }
        }

        return sb.toString();
    }


    public static String frequencySortMoreEfficient(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (Character ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue =
                new PriorityQueue<>(
                        (a, b) -> b.getValue() - a.getValue()
                );

        queue.addAll(freqMap.entrySet());

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> elem = queue.poll();
            sb.append(String.valueOf(elem.getKey()).repeat(elem.getValue()));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("eeeee"));
    }
}
