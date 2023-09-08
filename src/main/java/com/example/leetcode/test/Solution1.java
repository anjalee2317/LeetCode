package com.example.leetcode.test;

import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(newList(new String[]{"Anjalee 5 5 6, Kokila 8 9 10"}));
    }

    public static String newList(String[] students) {

        String str = Arrays.toString(students);
        String[] studentList = str.substring(1, str.length() - 1).split(",");
        StringBuilder stringBuilder = new StringBuilder();
        for (String student : studentList) {
            String name = "";
            int total = 0, count = 0, avg = 0;

            String[] studentMarks = student.trim().split(" ");
            for (String marks : studentMarks) {
                if (marks.matches("[a-zA-Z]+")) {
                    name = marks;
                } else {
                    int intMarks = Integer.parseInt(marks);
                    if (intMarks <= 10 && intMarks >= 1) {
                        total = total + intMarks;
                        count++;
                    }
                }
            }
            avg = (total + 1) / count;
            stringBuilder.append(name).append("-").append(avg).append(";").append(" ");
        }
        return stringBuilder.toString();
    }
}
