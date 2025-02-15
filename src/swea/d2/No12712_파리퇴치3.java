package swea.d2;

import java.util.Scanner;

public class No12712_파리퇴치3 {
    /*
        - 십자 탐색, 엑스자 탐색 모두해서 각 지점마다의 최대 잡을 수 있는 파리의
          마리 수 구하기
     */
    // 8방향 탐색
    static int[] dirY = {0,0,1,-1,1,-1,1,-1};
    static int[] dirX = {-1,1,0,0,1,-1,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        for(int test = 1; test <= testCase; test++) {
            // 배열의 크기
            int N = sc.nextInt();
            // 파리 잡는 범위
            int M = sc.nextInt();
            int[][] board = new int[N][N];

            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[i].length; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            int max = Integer.MIN_VALUE;
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[i].length; j++) {
                    int sumPlus = board[i][j];
                    int sumCross = board[i][j];
                    for(int m = 1; m < M; m++) {
                        for(int dirPlus = 0; dirPlus < 4; dirPlus++) {
                            int nextY = i + dirY[dirPlus] * m;
                            int nextX = j + dirX[dirPlus] * m;

                            if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                                sumPlus += board[nextY][nextX];
                            }
                        }

                        for(int dirCross = 4; dirCross < dirX.length; dirCross++) {
                            int nextY = i + dirY[dirCross] * m;
                            int nextX = j + dirX[dirCross] * m;

                            if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                                sumCross += board[nextY][nextX];
                            }
                        }
                    }
                    max = Math.max(max,Math.max(sumPlus,sumCross));
                }
            }

            System.out.printf("#%d %d\n", test, max);
        }
    }
}
