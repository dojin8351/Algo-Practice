package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1189_컴백홈 {
    static char[][] boards;
    static boolean[][] visited;
    static int[] dirY = {0, 0, 1, -1}; // 상, 하, 좌, 우
    static int[] dirX = {1, -1, 0, 0}; // 상, 하, 좌, 우
    static int result = 0;
    static int targetDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 파싱: 보드 크기 및 목표 거리
        String[] inputs = br.readLine().split(" ");
        int ySize = Integer.parseInt(inputs[0]);
        int xSize = Integer.parseInt(inputs[1]);
        targetDistance = Integer.parseInt(inputs[2]);

        // 보드 입력 파싱
        boards = new char[ySize][xSize];
        visited = new boolean[ySize][xSize];
        for (int i = 0; i < ySize; i++) {
            boards[i] = br.readLine().toCharArray(); // 행 데이터를 문자 배열로 읽음
        }

        // 시작점 (왼쪽 아래)과 도착점 (오른쪽 위)
        int startY = ySize - 1; // 시작점: 맨 왼쪽 아래
        int startX = 0;
        visited[startY][startX] = true;

        // DFS 탐색 시작
        dfs(startY, startX, 1);

        System.out.println(result);
    }

    public static void dfs(int y, int x, int distance) {
        // 도착 조건 체크
        if (y == 0 && x == boards[0].length - 1) { // 오른쪽 위 도착
            if (distance == targetDistance) {
                result++; // 유효한 경로 발견
            }
            return;
        }

        // 다음 경로 탐색
        for (int i = 0; i < 4; i++) {
            int ny = y + dirY[i];
            int nx = x + dirX[i];

            // 유효한 탐색 위치인지 확인
            if (ny >= 0 && nx >= 0 && ny < boards.length && nx < boards[0].length
                    && boards[ny][nx] == '.' && !visited[ny][nx]) {
                // 다음 위치 방문 처리 후 재귀 호출
                visited[ny][nx] = true;
                dfs(ny, nx, distance + 1);
                visited[ny][nx] = false; // 백트래킹: 방문 해제
            }
        }
    }
}
