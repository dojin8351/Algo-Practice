package swea.d3;

import java.util.Scanner;

public class 거듭제곱 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for(int tc = 1; tc <= T; tc++) {
            sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println("#" + tc + " " + pow(N,M));
        }
    }

    static int pow(int n, int m) {
        if(m == 1) {
            return n;
        }
        return n * pow(n, m-1);
    }

    static int pow2(int n, int m) {
        if(m == 1) {
            return n;
        }

        if(m % 2 == 0) {
            int temp = pow2(n, m/2);
            return temp * temp;
        }else {
            int temp = pow2(n, (m-1) / 2);
            return temp * temp * n;
        }
    }
}