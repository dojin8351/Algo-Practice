package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] grades = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"};
        float[] scores = {4.5f, 4.0f, 3.5f, 3.0f, 2.5f, 2.0f, 1.5f, 1.0f, 0.0f, 0.0f};
        Map<String, Float> scoreMap = new HashMap<>();

        for(int i = 0; i < grades.length; i++) {
            scoreMap.put(grades[i], scores[i]);
        }

        List<Student> students = new ArrayList<>();

        for(int i = 0; i < 20; i++) {
            String[] input = br.readLine().split(" ");
            float score = Float.parseFloat(input[1]);
            Student student = new Student(input[0],score,input[2]);
            students.add(student);
        }

        float totalScore = 0.0f;
        float totalCredit = 0.0f;
        float avg;
        for(Student student : students) {
            if(!student.grade.equals("P")) {
                totalCredit += student.score;
                totalScore += student.score * scoreMap.get(student.grade);
            }
        }
        avg = totalScore / totalCredit;
        System.out.println(avg);
    }

    static class Student {
        String name;
        float score;
        String grade;
        public Student(String name, float score, String grade) {
            this.name = name;
            this.score = score;
            this.grade = grade;
        }
    }
}
