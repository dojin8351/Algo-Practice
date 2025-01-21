package baekjoon;

import java.util.Scanner;

public class No1592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();

        int[] arr = new int[N];
        arr[0] = 1;
        int index = 0;
        int cnt = 0;

        while (true) {
            if (arr[index] == M) {
                System.out.println(cnt);
                break;
            }

            if (arr[index] % 2 == 1) {
                index = (index + L) % N;
            } else {
                index = (index - L + N) % N;
            }

            arr[index]++;
            cnt++;
        }
    }
}
