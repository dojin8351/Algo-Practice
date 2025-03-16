package swea.d3;

import java.util.Scanner;

public class N_Queen {
    // N: 체스판 크기 (N x N)
    static int N;
    // board: N x N 크기의 체스판을 나타내는 2차원 배열 (0: 빈 칸, 1: 퀸 배치)
    static int[][] board;
    // count: 퀸을 놓을 수 있는 모든 경우의 수
    static int count;

    // dirY, dirX: 8방향 탐색 배열 (위, 아래, 왼쪽, 오른쪽, 대각선 4개)
    static int[] dirY = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dirX = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) {
        // 입력을 처리하기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // T: 테스트 케이스의 수
        int T = sc.nextInt();

        // 각 테스트 케이스에 대해 N-Queen 풀기
        for (int test = 1; test <= T; test++) {
            N = sc.nextInt(); // 체스판 크기 입력
            board = new int[N][N]; // N x N 체스판 초기화
            count = 0; // 가능한 경우의 수 초기화

            // 첫 번째 열(x=0)부터 백트래킹 시작
            solve(0);

            // 결과 출력
            System.out.println("#" + test + " " + count);
        }
    }

    // solve: 재귀적으로 특정 열(x)에 퀸을 배치하는 함수 (백트래킹 방식)
    public static void solve(int x) {
        // 종료 조건: 모든 열에 퀸을 배치한 경우 (x가 N에 도달)
        if (x == N) {
            count++; // 경우의 수 증가
            return;
        }

        // 현재 열(x)에 대해 각 행(y)에 퀸 배치 시도
        for (int y = 0; y < N; y++) {
            // 해당 위치(y, x)가 안전한지 검사
            if (isSafe(y, x)) {
                board[y][x] = 1; // 퀸 배치
                solve(x + 1);    // 다음 열로 이동 (재귀 호출)
                board[y][x] = 0; // 퀸 배치 해제 (백트래킹)
            }
        }
    }

    // isSafe: 특정 위치(y, x)가 다른 퀸들과 충돌하지 않는지 확인하는 함수
    public static boolean isSafe(int y, int x) {
        // 8방향 탐색 (dirY, dirX 배열을 사용하여 모든 방향 검사)
        for (int d = 0; d < 8; d++) {
            int nextY = y; // 현재 행
            int nextX = x; // 현재 열

            // 한 방향으로 계속 이동하며 충돌 여부 확인
            while (true) {
                nextY += dirY[d]; // 다음 행 계산
                nextX += dirX[d]; // 다음 열 계산

                // 체스판 범위를 벗어나면 루프 종료
                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) {
                    break;
                }

                // 퀸(1)이 이미 있을 경우 현재 위치는 안전하지 않음
                if (board[nextY][nextX] == 1) {
                    return false;
                }
            }
        }

        // 모든 방향을 검사했을 때 안전하다면 true 반환
        return true;
    }
}