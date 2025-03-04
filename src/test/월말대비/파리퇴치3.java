package test.월말대비;

import java.util.Scanner;

public class 파리퇴치3 {

    // + , x 의 탐색도구
    static int[] dirY ={0,0,1,-1,1,1,-1,-1};
    static int[] dirX ={1,-1,0,0,1,-1,1,-1};
    static int[][] boards;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int test = 1; test <= testCase; test++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            boards = new int[N][N];
            // boards채우기
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    boards[i][j] = sc.nextInt();
                }
            }
            int maxCatch = 0;
            for(int i = 0 ; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    maxCatch = Math.max(maxCatch, catchBug(i,j,M));
                }
            }
            System.out.println("#" + test + " " + maxCatch);

        }
    }

    static int catchBug(int startY, int startX, int power) {
        int plusCatchCnt = boards[startY][startX];
        int xCatchCnt = boards[startY][startX];
        for(int p = 1; p < power; p++) {
            for (int i = 0; i < 4; i++) {
                int nextY = startY + dirY[i]*p;
                int nextX = startX + dirX[i]*p;

                if (nextY >= 0 && nextX >= 0 && nextY < boards.length && nextX < boards.length) {
                    plusCatchCnt += boards[nextY][nextX];
                }
            }

            for(int i = 4; i < dirX.length; i++) {
                int nextY = startY + dirY[i]*p;
                int nextX = startX + dirX[i]*p;

                if (nextY >= 0 && nextX >= 0 && nextY < boards.length && nextX < boards.length) {
                    xCatchCnt += boards[nextY][nextX];
                }
            }
        }

        return Math.max(plusCatchCnt,xCatchCnt);
    }
}
