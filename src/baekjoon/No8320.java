package baekjoon;

import java.util.Scanner;

public class No8320 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = i; j <=n; j++) {
                if(i * j <= n) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
