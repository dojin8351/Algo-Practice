package swea.모의고사;/*
    문제.
    맵의 크기는 5부터 20사이
    입력값은 0부터 500사이 중복되는 값은 없음
    이동은 사방으로 이동가능함
    현재좌표보다 더 낮은곳으로 이동해야 함
    네방향(상하좌우) 중에서 현재 좌표보다 낮은 곳 중에서 가장 낮은 곳으로 이동
    가장 많이 이동이 가능한게 몇번 이동인지 출력 
    초기 좌표는 주어지지 않고 맵 전체에서 가장 많이 움직일 수 있는 위치를 찾는다.
    
    이동 조건
        1. 현재좌표에서 상,하,좌,우 로만 이동가능
        2. 현재좌표의 값보다 작은 값 중 최소값으로 이동
    테스트케이스
        맵 크기: 5~20 사이
        값 범위: 0~500
        중복 없음
 */
import java.util.Scanner;

public class IM강사님풀이 {

    static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
    static int[] dc = { 0, 0, -1, 1 };
    static int N, ans;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner("""
                3
                5
                25 24 23 22 21
                20 19 18 17 16
                15 14 13 12 11
                10 9  8  7  6
                5  4  3  2  1
                7
                49 48 47 46 45 44 43
                42 41 40 39 38 37 36
                35 34 33 32 31 30 29
                28 27 26 25 24 23 22
                21 20 19 18 17 16 15
                14 13 12 11 10 9  8
                7  6  5  4  3  2  1
                6
                36 35 34 33 32 31
                30 29 28 27 26 25
                24 23 22 21 20 19
                18 17 16 15 14 13
                12 11 10 9  8  7
                6  5  4  3  2  1
                
                9번 이동
                25(0,0) → 24(0,1) → 23(0,2) → 22(0,3) → 21(0,4) → 16(1,4) → 11(2,4) → 6(3,4) → 1(4,4)
                13번 이동
                49(0,0) → 48(0,1) → 47(0,2) → 46(0,3) → 45(0,4) → 44(0,5) → 43(0,6) → 36(1,6) → 29(2,6) → 22(3,6) → 15(4,6) → 8(5,6) → 1(6,6)
                11번 이동
                36(0,0) → 35(0,1) → 34(0,2) → 33(0,3) → 32(0,4) → 31(0,5) → 25(1,5) → 19(2,5) → 13(3,5) → 7(4,5) → 1(5,5)
                """);
        int T = sc.nextInt(), t = 0;

        while (t++ < T) {
            N = sc.nextInt();
            map = new int[N][N];
            ans = 0;

            // 맵 입력
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    map[r][c] = sc.nextInt();
                }
            }

            // 모든 위치에서 시작
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    findMaxMove(r, c);
                }
            }
            System.out.println("#" + t + " " + ans);
        }

        sc.close();
    }

    private static void findMaxMove(int r, int c) {
        int count = 1;
        // 이동할 수 있을 때까지 반복
        while (true) {
            int minHeight = Integer.MAX_VALUE;
            int nextR = -1;
            int nextC = -1;

            // 네 방향 탐색
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                // 현재 값보다 작고, 지금까지 찾은 다음 값보다 작은 경우
                if (map[nr][nc] < map[r][c] && map[nr][nc] < minHeight) {
                    minHeight = map[nr][nc];
                    nextR = nr;
                    nextC = nc;
                }
            }

            // 더 이상 이동할 수 없으면 종료
            if (nextR == -1)
                break;

            // 다음 위치로 이동
            r = nextR;
            c = nextC;
            count++;
        }

        ans = Math.max(ans, count);
    }
}