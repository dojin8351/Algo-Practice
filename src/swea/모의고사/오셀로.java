package swea.모의고사;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 오셀로 {
    // 1 흑, 2 백
    static int[][] boards;
    static int[] dirY = {0,0,1,-1,1,-1,1,-1};
    static int[] dirX = {-1,1,0,0,1,-1,-1,1};
    static List<int[]> indexList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int testNum = 1; testNum <= testCase; testNum++) {
            int boardSize = sc.nextInt();
            int playCnt = sc.nextInt();
            boards = new int[boardSize][boardSize];

            boards[boardSize/2 -1][boardSize/2 -1] = 2;
            boards[boardSize/2][boardSize/2] = 2;
            boards[boardSize/2][boardSize/2 -1] = 1;
            boards[boardSize/2-1][boardSize/2] =1;
            int cnt = 1;
            while(cnt <= playCnt) {
                int X = sc.nextInt()-1;
                int Y = sc.nextInt()-1;
                int color = sc.nextInt();

                changeAndCheck(Y, X, color);

                cnt++;
            }
            int black = 0;
            int white = 0;
            for(int i = 0; i < boardSize; i++) {
                for(int j = 0; j < boardSize; j++) {
                    if(boards[i][j] == 1) {
                        black++;
                    } else if(boards[i][j] == 2) {
                        white++;
                    }
                }
            }
            System.out.println("#" + testNum + " " + black + " " + white);
        }
    }

    static void changeAndCheck(int Y, int X, int color) {
        // 이미 돌이 놓여있는 자리인지 확인
        if (boards[Y][X] != 0) {
            return;
        }

        boolean canPut = false;

        // 8방향 탐색
        for (int i = 0; i < dirX.length; i++) {
            indexList.clear(); // 각 방향마다 뒤집을 좌표 초기화

            // 첫 번째 칸 탐색
            int nextY = Y + dirY[i];
            int nextX = X + dirX[i];

            // 경계를 벗어나거나 첫 번째 칸이 빈 칸이거나 자기 색 돌이면
            if (nextY < 0 || nextY >= boards.length || nextX < 0 || nextX >= boards[0].length ||
                    boards[nextY][nextX] == 0 || boards[nextY][nextX] == color) {
                //패스
                continue;
            }

            // 유효한 방향으로 계속 탐색
            int length = 1;
            while (true) {
                nextY = Y + dirY[i] * length;
                nextX = X + dirX[i] * length;

                // 경계를 벗어나면 탐색 종료
                if (nextY < 0 || nextY >= boards.length || nextX < 0 || nextX >= boards[0].length) {
                    indexList.clear();
                    break;
                }

                // 빈 칸을 만나면 스톱
                if (boards[nextY][nextX] == 0) {
                    indexList.clear();
                    break;
                }

                // 자신의 돌을 뒤집기시작
                if (boards[nextY][nextX] == color) {
                    if (!indexList.isEmpty()) {
                        canPut = true;
                        // 뒤집기
                        for (int[] arr : indexList) {
                            boards[arr[0]][arr[1]] = color;
                        }
                    }
                    break;
                }

                // 다른색돌이라면 뒤집을 리스트에 추가
                indexList.add(new int[]{nextY, nextX});

                length++;
            }
        }
        // 모든 검증 다 지나면 돌놓을수 있음
        if (canPut) {
            boards[Y][X] = color;
        }

    }
}
