package test.월말대비;

import java.util.Arrays;
import java.util.Scanner;

public class 오목판정 {
    static int[] dirY = {1,-1,0,0,1,1,-1,-1};
    static int[] dirX = {0,0,1,-1,1,-1,-1,1};
    static char[][] boards;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        for(int test = 1; test <= testCase; test++) {
            int N = sc.nextInt();
            boards = new char[N][N];

            for(int i = 0; i < N; i++) {
                boards[i] = sc.next().toCharArray();
            }
            boolean isOmok = false;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(isOmok(i,j)) {
                        isOmok = true;
                        break;
                    }
                }
            }

            if(isOmok) {
                System.out.println("#" + test + " " + "YES");
            } else {
                System.out.println("#" + test + " " + "NO");
            }
        }
    }

    static boolean isOmok(int y, int x) {
        for(int i = 0; i < dirX.length; i++) {
            int omokCnt = 0;
            for(int j = 0; j < 5; j++) {
                int nextY = y + dirY[i] * j;
                int nextX = x + dirX[i] * j;

                if(nextY >= 0 && nextX >= 0 && nextY < boards.length && nextX < boards.length) {
                    if(boards[nextY][nextX] == 'o') {
                        omokCnt++;
                    }
                }
            }
            if(omokCnt == 5) {
                return true;
            }
        }
        return false;
    }
}
