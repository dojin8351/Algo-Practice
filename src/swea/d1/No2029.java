package swea.d1;

import java.util.Scanner;

public class No2029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCnt = sc.nextInt();

        for(int i = 0; i < testCaseCnt; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.printf("#%d %d %d\n", i+1, a/b, a%b);
        }
    }
}
