package baekjoon;

import java.util.Scanner;

public class No10870_피보나치수5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
