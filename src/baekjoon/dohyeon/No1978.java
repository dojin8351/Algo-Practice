package baekjoon.dohyeon;

import java.util.Scanner;

public class No1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        boolean ynValue = true;

        for(int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            if(yn(a)) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    public static boolean yn(int n) {
        if(n < 2) {
            return false;
        }

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
