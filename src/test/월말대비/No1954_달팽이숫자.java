package test.월말대비;

import java.util.Scanner;

public class No1954_달팽이숫자 {
    static int[] dirY = {0,1,0,-1};
    static int[] dirX = {1,0,-1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int test = 1; test <=testCase; test++) {
            int N = sc.nextInt();
            int[][] boards = new int[N][N];

            int num = 1;
            int y = 0;
            int x = 0;
            int dir = 0;
            boards[y][x] = num;

            while(num < N * N) {
                int nextY = y + dirY[dir];
                int nextX = x + dirX[dir];

                if(nextY >= 0 && nextX >= 0 && nextY < N && nextX < N && boards[nextY][nextX] == 0){
                    y = nextY;
                    x = nextX;
                    boards[y][x] = ++num;
                } else {
                    dir = (dir+1) % 4;
                }
            }
            System.out.println("#" + test);
            for (int[] row : boards) {
                for (int n : row) {
                    System.out.print(n + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }

}
