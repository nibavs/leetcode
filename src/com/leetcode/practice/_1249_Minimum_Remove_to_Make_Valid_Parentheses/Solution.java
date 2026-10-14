package com.leetcode.practice._1249_Minimum_Remove_to_Make_Valid_Parentheses;

class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        int validPairs = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(') {
                counter++;
                sb.append(current);
            } else if (current == ')') {
                if (counter == 0) continue;
                validPairs++;
                counter--;
                sb.append(current);
            } else {
                sb.append(current);
            }
        }

        String str = sb.toString();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current == '(') {
                validPairs--;
                if (validPairs < 0) continue;
                result.append(current);
            } else {
                result.append(current);
            }
        }
        return result.toString();
    }
}
