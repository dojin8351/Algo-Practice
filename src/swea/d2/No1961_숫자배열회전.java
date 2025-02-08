package swea.d2;

import java.util.Scanner;

public class No1961_숫자배열회전 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int i = 0; i < testCase; i++) {
            int N = sc.nextInt();

            int[][]arr = new int[N][N];
            int[][]arr90 = new int[N][N];
            int[][]arr180 = new int[N][N];
            int[][]arr270 = new int[N][N];

            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    arr[j][k] = sc.nextInt();
                    arr90[k][N-j-1] = arr[j][k];
                    arr180[N-j-1][N-k-1] = arr[j][k];
                    arr270[N-k-1][j] = arr[j][k];
                }
            }

            System.out.println("#" + (i+1));
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    System.out.print(arr90[j][k]);
                }
                System.out.print(" ");
                for(int k = 0; k < N; k++) {
                    System.out.print(arr180[j][k]);
                }
                System.out.print(" ");
                for(int k = 0; k < N; k++) {
                    System.out.print(arr270[j][k]);
                }
                System.out.println();
            }

        }
    }
}
