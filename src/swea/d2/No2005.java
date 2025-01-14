package swea.d2;

import java.util.Scanner;

public class No2005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            System.out.printf("#%d\n", t);

            int[][] triangle = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        triangle[i][j] = 1;
                    } else {
                        triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                    }
                    System.out.print(triangle[i][j] + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
