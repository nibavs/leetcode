package com.leetcode.practice._49_Group_Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> maps = new HashMap<>();

        for (String str : strs) {
            int[] int26 = new int[26];

            for (char c : str.toCharArray()) {
                int26[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int num : int26) {
                sb.append(num).append('.');
            }
            String key = sb.toString();
            maps.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(maps.values());
    }

    public static void main(String[] args) {
        String[] mass = new String[] {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(mass));
    }
}
