package test.월말대비;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class No1974_스도쿠검증 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int test = 1; test <= testCase; test++) {
            int boardSize = 9;
            int[][] boards = new int[boardSize][boardSize];
            for(int i = 0; i < boardSize; i++) {
                for(int j = 0; j < boardSize; j++) {
                    boards[i][j] = sc.nextInt();
                }
            }

            boolean isSudoku = true;

            for(int i = 0; i < boardSize; i++) {
                Set<Integer> vld = new HashSet<>();
                for(int j = 0; j < boardSize; j++) {
                    vld.add(boards[i][j]);

                }
                if(vld.size() != 9) {
                    isSudoku = false;
                }
            }

            for(int j = 0; j < boardSize; j++) {
                Set<Integer> vld = new HashSet<>();
                for(int i  = 0; i < boardSize; i++) {
                    vld.add(boards[i][j]);

                }
                if(vld.size() != 9) {
                    isSudoku = false;
                }
            }

            for(int i = 0; i < boardSize; i += 3) {
                for(int j = 0; j < boardSize; j += 3) {
                    Set<Integer> vld = new HashSet<>();

                    for(int row = 0; row < 3; row++) {
                        for(int col = 0; col < 3; col++) {
                            vld.add(boards[i+row][j+col]);
                        }
                    }

                    if(vld.size() != 9) {
                        isSudoku = false;
                        break;
                    }
                }
            }

            if(isSudoku) {
                System.out.println("#"+test+ " " + "1");
            } else {
                System.out.println("#"+test+ " " + "0");
            }



        }
    }
}
