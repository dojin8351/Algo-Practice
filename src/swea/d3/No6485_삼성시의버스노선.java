package swea.d3;

import java.util.Scanner;

public class No6485_삼성시의버스노선 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int test = 1; test <= testCase; test++) {
            StringBuilder sb = new StringBuilder();
            int N = sc.nextInt();
            int[] board = new int[5001];

            for(int i = 0; i < N; i++) {
                int A = sc.nextInt() - 1;
                int B = sc.nextInt() - 1;

                for(int j = A; j <= B; j++) {
                    board[j]++;
                }
            }
            sb.append("#").append(test).append(" ");
            int P = sc.nextInt();
            for(int i = 0; i < P; i++) {
                int C = sc.nextInt()-1;
                sb.append(board[C]).append(" ");
            }
            sb.append("\n");

            System.out.println(sb.toString().trim());
        }
    }
}
