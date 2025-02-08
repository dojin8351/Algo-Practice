package swea.d2;

import java.util.Scanner;

public class No1954_달팽이숫자 {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];

            int x = 0, y = 0;
            int dir = 0;
            int num = 1;

            while (num <= N * N) {
                arr[x][y] = num++;

                int nx = x + DIRECTIONS[dir][0];
                int ny = y + DIRECTIONS[dir][1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] != 0) {
                    dir = (dir + 1) % 4;
                    nx = x + DIRECTIONS[dir][0];
                    ny = y + DIRECTIONS[dir][1];
                }

                x = nx;
                y = ny;
            }

            System.out.println("#" + (t + 1));
            for (int[] row : arr) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }
    }
}