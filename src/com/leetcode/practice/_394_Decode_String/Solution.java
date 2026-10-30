package com.leetcode.practice._394_Decode_String;

class Solution {
    int i = 0;
    public String decodeString(String s) {
        i = 0;

        return rec(s);
    }

    private String rec(String s) {
        StringBuilder res = new StringBuilder();
        int numb = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                numb *= 10;
                numb += ch - '0';
                i++;
            } else if (ch == '[') {
                i++;
                String inner = rec(s);
                for (int k = 0; k < numb; k++) res.append(inner);
                numb = 0;
            } else if (ch == ']') {
                i++;
                return res.toString();
            } else {
                res.append(ch);
                i++;
            }
        }

        return res.toString();
    }
}
