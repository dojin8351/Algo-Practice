package swea.d2;

import java.util.Scanner;

public class No1979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[][] board = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            int result = 0;

            for (int i = 0; i < N; i++) {
                int count = 0;
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 1) {
                        count++;
                    } else {
                        if (count == K) {
                            result++;
                        }
                        count = 0;
                    }
                }
                if (count == K) {
                    result++;
                }
            }

            for (int j = 0; j < N; j++) {
                int count = 0;
                for (int i = 0; i < N; i++) {
                    if (board[i][j] == 1) {
                        count++;
                    } else {
                        if (count == K) {
                            result++;
                        }
                        count = 0;
                    }
                }
                if (count == K) {
                    result++;
                }
            }

            System.out.println("#" + t + " " + result);
        }
    }
}
