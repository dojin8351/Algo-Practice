package swea.d3;

import java.util.Scanner;

public class No4698_테네스의특별한소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        // 소수 판별을 위한 에라토스테네스의 체 적용 범위를 설정
        int maxLimit = 1000000;
        boolean[] isPrime = sieveOfEratosthenes(maxLimit);

        for (int i = 1; i <= testCase; i++) {
            int D = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();

            int cnt = 0;

            // A에서 B 사이의 숫자 중 소수인지 확인하고 D 포함 여부를 검사
            for (int j = A; j <= B; j++) {
                if (isPrime[j] && String.valueOf(j).contains(String.valueOf(D))) {
                    cnt++;
                }
            }

            System.out.println("#" + i + " " + cnt);
        }
    }

    // 에라토스테네스의 체
    public static boolean[] sieveOfEratosthenes(int max) {
        boolean[] isPrime = new boolean[max + 1];

        // 일단 모든 수를 소수로 초기화
        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }

        // 소수 판별
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) { // i의 배수들을 제거
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }
}