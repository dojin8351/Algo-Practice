package baekjoon;

import java.util.Scanner;

public class No2999 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int inputLength = input.length();
        int R = 1;
        int C = inputLength;

        for(int i = 1; i <= Math.sqrt(inputLength); i++){
            if(inputLength % i == 0){
                R = i;
                C = inputLength / i;
            }
        }

        char[][] map = new char[R][C];

        int n = 0;
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                map[j][i] = input.charAt(n++);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
        }
    }
}