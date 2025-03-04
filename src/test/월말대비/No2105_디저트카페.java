package test.월말대비;

import java.util.*;

public class No2105_디저트카페 {

    static int[] dirY = {1, 1, -1, -1};
    static int[] dirX = {1, -1, -1, 1};
    static int[][] boards; // 디저트 카페 지도
    static int max; // 최대 디저트 개수
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        for (int test = 1; test <= testCase; test++) {
            int boardsSize = sc.nextInt();
            boards = new int[boardsSize][boardsSize];
            visited = new boolean[boardsSize][boardsSize];
            max = -1;

            for (int i = 0; i < boardsSize; i++) {
                for (int j = 0; j < boardsSize; j++) {
                    boards[i][j] = sc.nextInt();
                }
            }

            // 모든 점을 시작점으로 DFS 탐색
            for (int i = 0; i < boardsSize; i++) {
                for (int j = 0; j < boardsSize; j++) {
                    // 새로운 탐색 시작
                    visited[i][j] = true; // 시작점을 방문 처리
                    Set<Integer> initialSet = new HashSet<>();
                    initialSet.add(boards[i][j]); // 첫 번째 디저트 추가
                    dfs(i, j, i, j, 0, 1, initialSet);
                    visited[i][j] = false; // 탐색 끝난 후 해제
                }
            }

            // 결과 출력
            System.out.println("#" + test + " " + max);
        }
    }

    static void dfs(int startY, int startX, int curY, int curX, int direction, int count, Set<Integer> eatDessert) {
        // 네 방향 모두 탐색
        for (int i = direction; i < 4; i++) {
            int nextY = curY + dirY[i];
            int nextX = curX + dirX[i];

            if (nextY >= 0 && nextX >= 0 && nextY < boards.length && nextX < boards.length) {
                // 시작점으로 돌아온 경우 (사각형 완성)
                if (nextY == startY && nextX == startX && count >= 4) {
                    max = Math.max(max, count);
                    continue;
                }

                // 방문하지 않았고, 새 디저트라면 탐색 진행
                if (!visited[nextY][nextX] && !eatDessert.contains(boards[nextY][nextX])) {
                    visited[nextY][nextX] = true;
                    eatDessert.add(boards[nextY][nextX]);

                    dfs(startY, startX, nextY, nextX, i, count + 1, eatDessert);

                    visited[nextY][nextX] = false;
                    eatDessert.remove(boards[nextY][nextX]);
                }
            }
        }
    }
}