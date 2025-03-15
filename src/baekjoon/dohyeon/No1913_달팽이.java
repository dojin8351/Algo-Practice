package baekjoon.dohyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class No1913_달팽이 {
    static int[] directionsY = {1, 0, -1, 0}; // 아래, 오른쪽, 위, 왼쪽
    static int[] directionsX = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());    // 배열 크기
        int target = Integer.parseInt(br.readLine());  // 찾고자 하는 숫자

        int[][] board = new int[size][size]; // 달팽이 배열
        int num = size * size;   // 채우는 숫자 (최대 숫자부터 시작)

        int y = 0;               // 현재 y 좌표
        int x = 0;               // 현재 x 좌표
        int direction = 0;       // 현재 진행 방향 (0: 아래, 1: 오른쪽, 2: 위, 3: 왼쪽)

        int targetY = 0, targetX = 0; // target 값의 위치를 저장할 변수

        while (num > 0) {
            // 현재 위치에 숫자 채우기
            board[y][x] = num;

            if (num == target) { // target 값 위치 기록
                targetY = y;
                targetX = x;
            }

            // 다음 위치 계산
            int nextY = y + directionsY[direction];
            int nextX = x + directionsX[direction];

            // 이동할 수 없는 경우 방향 변경
            if (nextY < 0 || nextX < 0 || nextY >= size || nextX >= size || board[nextY][nextX] != 0) {
                direction = (direction + 1) % 4; // 방향 전환 (0 → 1 → 2 → 3 반복)
                nextY = y + directionsY[direction];
                nextX = x + directionsX[direction];
            }

            // 다음 위치로 이동
            y = nextY;
            x = nextX;
            num--;
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(board[i][j]).append(" ");
            }
            if(i == size-1) {
                sb.append("");
            } else {
                sb.append("\n");
            }
        }
        System.out.println(sb);

        // target 값의 위치 출력
        System.out.println((targetY + 1) + " " + (targetX + 1)); // 1-based index로 출력
    }
}