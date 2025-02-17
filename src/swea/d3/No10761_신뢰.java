package swea.d3;

import java.io.IOException;
import java.util.Scanner;

public class No10761_신뢰 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int test = 1; test <= testCase; test++) {
            int num = sc.nextInt();

            // 각 로봇의 위치와 시간 초기화
            int locationB = 1, locationO = 1;
            int time = 0, timeB = 0, timeO = 0;

            for (int i = 0; i < num; i++) {
                String robot = sc.next();
                int target = sc.nextInt();

                if (robot.equals("B")) {
                    int moveTime = Math.abs(target - locationB); // 로봇 B가 이동 시간
                    timeB = Math.max(timeB, time) + moveTime + 1; // 현재 시간부터 대기 + 이동 + 버튼 누르기
                    locationB = target; // 위치 업데이트
                    time = timeB; // 전체 시간 갱신
                } else if (robot.equals("O")) {
                    int moveTime = Math.abs(target - locationO); // 로봇 O가 이동 시간
                    timeO = Math.max(timeO, time) + moveTime + 1; // 현재 시간부터 대기 + 이동 + 버튼 누르기
                    locationO = target; // 위치 업데이트
                    time = timeO; // 전체 시간 갱신
                }
            }

            System.out.println("#" + test + " " + time);
        }

    }
}