package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class No13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 전체 학생 수
        int K = sc.nextInt(); // 한 방 최대 인원

        StudentCountManager studentCountManager = new StudentCountManager();

        for (int i = 0; i < N; i++) {
            int S = sc.nextInt(); // 성별
            int Y = sc.nextInt(); // 학년

            studentCountManager.addStudent(S, Y);
        }
        int totalRoomCount = 0;

        for(String key : studentCountManager.studentCount.keySet()) {
            int gender = Integer.parseInt(key.split("_")[0]);
            int grade = Integer.parseInt(key.split("_")[1]);
            totalRoomCount += studentCountManager.getRoomCount(gender, grade, K);
        }
        System.out.println(totalRoomCount);
    }

    public static class StudentCountManager {
        private final Map<String, Integer> studentCount;

        public StudentCountManager() {
            studentCount = new HashMap<>();
        }

        public void addStudent(int gender, int grade) {
            String key = createKey(gender, grade);
            studentCount.put(key, studentCount.getOrDefault(key, 0) + 1);
        }

        private String createKey(int gender, int grade) {
            return gender + "_" + grade;
        }

        public int getRoomCount(int gender, int grade, int K) {
            String key = createKey(gender, grade);
            if(studentCount.get(key) % K != 0) {
                return studentCount.get(key) / K + 1;
            } else {
                return studentCount.get(key) / K;
            }
        }
    }

}
