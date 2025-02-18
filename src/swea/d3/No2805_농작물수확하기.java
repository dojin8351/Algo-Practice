package swea.d3;

import java.util.Arrays;
import java.util.Scanner;

public class No2805_농작물수확하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int i = 0; i < testCase; i++) {
            int n = sc.nextInt();
            int[][] farm = new int[n][n];

            for (int j = 0; j < n; j++) {
                String input = sc.next();
                farm[j] = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
            }

            int total = 0;
            int num = 0;
            for(int j = 0; j < n; j++) {
                if(j < n/2) {
                    for (int k = n / 2 - num; k <= n / 2 + num; k++) {
                        total += farm[j][k];
                    }
                    num++;
                } else if(j == n/2) {
                    for (int k = n / 2 - num; k <= n / 2 + num; k++) {
                        total += farm[j][k];
                    }
                }
                if (j > n / 2) {
                    num--;

                    for (int k = n / 2 - num; k <= n / 2 + num; k++) {
                        total += farm[j][k];
                    }
                }

            }
            System.out.println("#" + (i+1) + " " + total);
        }
    }
}
