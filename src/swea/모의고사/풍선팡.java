package swea.모의고사;

import java.util.Arrays;
import java.util.Scanner;

public class 풍선팡 {
    static int[][] direction = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int testNum = 1; testNum <= testCase; testNum++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] board = new int[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            int maxValue = 0;
            for(int y = 0; y < N; y++) {
                for(int x = 0; x < M; x++) {
                    int flower = board[y][x];
                    int sum = flower;

                    for(int i = 1; i <= flower; i++) {
                        for (int[] dir : direction) {
                            int nextY = y + dir[0] * i;
                            int nextX = x + dir[1] * i;

                            if (nextY < N && nextX < M && nextY >= 0 && nextX >= 0) {
                                sum += board[nextY][nextX];
                            }
                        }
                    }
                    if(maxValue < sum) {
                        maxValue = sum;
                    }
                }
            }
            System.out.println(maxValue);
        }
    }
}
