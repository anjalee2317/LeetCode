package com.example.leetcode.test;

import java.util.Arrays;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(password(new String[]{"pAs4Wo2d, PAAS6word, p00sWord"}, "4dro6"));
    }

    public static String password(String[] passwords, String checkString) {

        String correctPassword = "";
        String str = Arrays.toString(passwords);
        String[] pwList = str.substring(1, str.length() - 1).split(",");
        String checkStr = checkString.substring(1, checkString.length() - 1);
        StringBuilder reverseStr = new StringBuilder();
        reverseStr.append(checkStr);
        reverseStr.reverse();

        for (String pass : pwList) {
            String pw = pass.trim();
            int sum = 0;
            int upper = 0;
            for (int i = 0; i < pw.length(); i++) {
                char ch = pw.charAt(i);
                if (ch >= 'A' && ch <= 'Z') {
                    upper++;
                }
                if (!Character.toString(ch).matches("[a-zA-Z]+")) {
                    sum = sum + Integer.parseInt(String.valueOf(ch));
                }
            }

            String lastDigit = String.valueOf(checkString.charAt(checkString.length() - 1));
            String firstDigit = String.valueOf(checkString.charAt(0));
            String last3Chars = pw.substring(pw.length() - 3);
            if ((Integer.parseInt(firstDigit) == upper) &&
                    (Integer.parseInt(lastDigit) == sum) &&
                    (last3Chars.contentEquals(reverseStr))) {
                correctPassword = pw;
            }
        }
        return correctPassword;
    }
}
