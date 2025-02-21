package baekjoon;

import java.util.Scanner;

public class No11050_이항계수1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int K = sc.nextInt();
        System.out.println(factorial(N)/(factorial(K)*factorial(N-K)));
    }

    public static int factorial(int num) {
        // 종료 조건: num이 1이거나 0일 때 1 반환
        if (num <= 1) {
            return 1;
        }

        // 재귀 호출: num 값을 감소시키며 호출
        return num * factorial(num - 1);
    }
}