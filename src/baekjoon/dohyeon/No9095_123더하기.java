package baekjoon.dohyeon;

import java.util.Scanner;

public class No9095_123더하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[] inputs = new int[T];
        int max = 0;

        for (int i = 0; i < T; i++) {
            inputs[i] = sc.nextInt();
            max = Math.max(max, inputs[i]);
        }

        int[] dp = new int[max + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int n : inputs) {
            System.out.println(dp[n]);
        }

    }
}
