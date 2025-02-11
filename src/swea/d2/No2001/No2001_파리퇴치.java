package swea.d2.No2001;

import java.util.Scanner;

public class No2001_파리퇴치 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();

        for(int i = 0; i < cnt; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] arrN = new int[n][n];

            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    int x = sc.nextInt();
                    arrN[j][k] = x;
                }
            }
            System.out.printf("#%d %d\n",i+1, getMax(n,m,arrN));
        }
    }

    private static int getMax(int n, int m, int[][] arr) {
        int max = 0;
        // 배열 범위 안넘치도록 범위 설정
        for(int i = 0; i <= n - m; i++) {
            for(int j = 0; j <= n - m; j++) {

                int maxSum = 0;
                // 배열내에서 m * m 크기의 배열 탐색후 그값을을 누적합해준다.
                for(int x = 0; x < m; x++){
                    for(int y = 0; y < m; y++){
                        maxSum += arr[i + x][j + y];
                    }
                }
                // max와 maxSum의 최대를 비교해 가장 큰아이를 max담아 리턴
                max = Math.max(maxSum, max);
            }
        }
        return max;
    }
}