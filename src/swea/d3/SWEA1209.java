package swea.d3;

import java.util.Scanner;

public class SWEA1209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int testCase = 1; testCase <= 10; testCase++) {
            int[][] board = new int[100][100];
            int size = 100; // 배열 크기

            // 배열 입력 받기
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            int maxValue = Integer.MIN_VALUE; // 최댓값 초기화

            // 1. 행의 합 계산 및 최대값 갱신
            for (int i = 0; i < size; i++) {
                int rowSum = 0;
                for (int j = 0; j < size; j++) {
                    rowSum += board[i][j];
                }
                maxValue = Math.max(maxValue, rowSum);
            }

            // 2. 열의 합 계산 및 최대값 갱신
            for (int j = 0; j < size; j++) {
                int colSum = 0;
                for (int i = 0; i < size; i++) {
                    colSum += board[i][j];
                }
                maxValue = Math.max(maxValue, colSum);
            }

            // 3. 오른쪽 아래 대각선 합
            int diagonal1Sum = 0;
            for (int i = 0; i < size; i++) {
                diagonal1Sum += board[i][i];
            }
            maxValue = Math.max(maxValue, diagonal1Sum);

            // 4. 왼쪽 아래 대각선 합
            int diagonal2Sum = 0;
            for (int i = 0, j = size - 1; i < size && j >= 0; i++, j--) {
                diagonal2Sum += board[i][j];
            }
            maxValue = Math.max(maxValue, diagonal2Sum);

            // 결과 출력
            System.out.printf("#%d %d\n", testCase, maxValue);
        }

        sc.close();
    }
}