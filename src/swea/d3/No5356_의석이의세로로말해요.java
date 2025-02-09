package swea.d3;

import java.util.Arrays;
import java.util.Scanner;

public class No5356_의석이의세로로말해요 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int i = 0; i < testCase; i++) {
            char[][] boards = new char[5][15];

            for(int j = 0; j < 5; j++) {
                String input = sc.next();
                boards[j] = input.toCharArray();
            }

            System.out.print("#" + (i+1) + " ");
            for (int k = 0; k < 15; k++) {
                for (int j = 0; j < 5; j++) {
                    if (k < boards[j].length) {
                        System.out.print(boards[j][k]);
                    }
                }
            }
            System.out.println();
        }
    }
}
