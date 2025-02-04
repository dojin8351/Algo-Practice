package task;

import java.util.Scanner;

public class SandClock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("홀수 자연수 N을 입력하세요 (N % 2 == 1): ");
        int N = scanner.nextInt();

        if (N % 2 == 0) {
            System.out.println("N은 반드시 홀수여야 합니다!");
            return;
        }

        int num = 1;

        for (int i = 0; i < N; i++) {
            int spaces = Math.abs(i - N / 2);
            int numbers = N - 2 * spaces;

            for (int j = 0; j < spaces; j++) {
                System.out.print("   ");
            }

            for (int j = 0; j < numbers; j++) {
                System.out.printf("%3d", num);
                num++;
            }

            System.out.println();
        }
    }
}