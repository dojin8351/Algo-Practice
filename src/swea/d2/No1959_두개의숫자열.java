package swea.d2;

import java.util.*;

public class No1959_두개의숫자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int test = 1; test <= testCase; test++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] arrayN = new int[N];
            int[] arrayM = new int[M];

            for (int i = 0; i < N; i++) {
                arrayN[i] = sc.nextInt();
            }

            for (int i = 0; i < M; i++) {
                arrayM[i] = sc.nextInt();
            }

            int max = Integer.MIN_VALUE;

            // N이 더 길거나 같을 때
            if (N >= M) {
                for (int i = 0; i <= N - M; i++) {
                    int sum = 0;
                    for (int j = 0; j < M; j++) {
                        sum += arrayN[i + j] * arrayM[j];
                    }
                    max = Math.max(max, sum);
                }
            }
            // M이 더 길 때
            else {
                for (int i = 0; i <= M - N; i++) {
                    int sum = 0;
                    for (int j = 0; j < N; j++) {
                        sum += arrayM[i + j] * arrayN[j];
                    }
                    max = Math.max(max, sum);
                }
            }

            System.out.println("#" + test + " " + max);
        }
    }
}