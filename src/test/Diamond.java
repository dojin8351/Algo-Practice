package test;

import java.util.Scanner;

public class Diamond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("홀수 자연수 N을 입력하세요 (N % 2 == 1): ");
        int N = scanner.nextInt();

        if (N % 2 == 0) {
            System.out.println("N은 반드시 홀수여야 합니다!");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i <= N / 2) {
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < N - 2 * i; j++) {
                    System.out.print("*");
                }
            } else {
                for (int j = 0; j < N - i - 1; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 2 * (i - N / 2) + 1; j++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
