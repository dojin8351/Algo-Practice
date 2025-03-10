package swea.모의고사;

import java.util.Scanner;

public class 거듭제곱 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = 10;
        for(int test = 1; test <= testCase; test++) {
            sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            int value = a;
            for(int j = 0; j < b-1; j++) {
                value *= a;
            }
            System.out.println("#" + test + " " + value);
        }
    }
}
