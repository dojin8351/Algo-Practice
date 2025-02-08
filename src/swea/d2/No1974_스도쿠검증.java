package swea.d2;

import java.util.Scanner;

public class No1974_스도쿠검증 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int i = 0; i < testCase; i++) {
            int[][] sudoku = new int[9][9];

            for(int j = 0; j < 9; j++) {
                for(int k = 0; k < 9; k++) {
                    sudoku[j][k] = sc.nextInt();
                }
            }

            if(checkSudoku(sudoku)) {
                System.out.println("#" + (i+1) + " " + "1");
            } else {
                System.out.println("#" + (i+1) + " " + "0");
            }

        }
    }

    public static boolean checkSudoku(int[][] sudoku) {
        boolean isSudoku = true;
        int total = 0;

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                total += sudoku[i][j];
            }
            if(total != 45) {
                isSudoku = false;
            }
            total = 0;
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                total += sudoku[j][i];
            }
            if(total != 45) {
                isSudoku = false;
            }
            total = 0;
        }

        for (int startX = 0; startX < 9; startX += 3) {
            for (int startY = 0; startY < 9; startY += 3) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        total += sudoku[startX + i][startY + j];
                    }
                }
                if (total != 45) {
                    isSudoku = false;
                }
                total = 0;
            }
        }


        return isSudoku;
    }
}
