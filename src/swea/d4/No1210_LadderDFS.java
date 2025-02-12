package swea.d4;

import java.util.Scanner;

public class No1210_LadderDFS {
    static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}}; // 왼쪽, 오른쪽, 위쪽
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int testCase = 1; testCase <= 10; testCase++) {
            board = new int[100][100];
            visited = new boolean[100][100];

            // 100x100 배열 입력
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            // 도착점(값이 2인 곳) 찾기
            int startRow = 99; // 맨 아래부터 시작
            int startCol = 0;
            for (int j = 0; j < 100; j++) {
                if (board[startRow][j] == 2) {
                    startCol = j;
                    break;
                }
            }

            // DFS로 최상단 열 번호 찾기
            int result = dfs(startRow, startCol);

            // 결과 출력
            System.out.println("#" + testCase + " " + result);
        }
        sc.close();
    }

    static int dfs(int row, int col) {
        if (row == 0) {
            return col;
        }

        visited[row][col] = true;

        for (int i = 0; i < 3; i++) {
            int nextRow = row + dir[i][0];
            int nextCol = col + dir[i][1];

            if (nextRow >= 0 && nextRow < 100 && nextCol >= 0 && nextCol < 100) {
                if (!visited[nextRow][nextCol] && board[nextRow][nextCol] == 1) {
                    int result = dfs(nextRow, nextCol);

                    if (result != -1) {
                        return result;
                    }
                }
            }
        }

        return -1;
    }
}