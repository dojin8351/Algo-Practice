package swea.모의고사;

import java.util.*;

public class 공굴러가유 {
    static int[] dirY = {-1, 1, 0, 0}; // 상하좌우 Y 좌표 이동
    static int[] dirX = {0, 0, 1, -1}; // 상하좌우 X 좌표 이동
    static int[][] boards;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for (int test = 1; test <= testCase; test++) {
            int N = sc.nextInt();
            boards = new int[N][N];

            // 보드 데이터 입력
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    boards[i][j] = sc.nextInt();
                }
            }

            int max = Integer.MIN_VALUE;

            // BFS 탐색 시작
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(max, bfs(i, j, N));
                }
            }

            // 결과 출력
            System.out.println("#" + test + " " + max);
        }
    }

    // BFS를 통한 탐색
    static int bfs(int startY, int startX, int N) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.offer(new int[]{startY, startX, 1}); // {y, x, length}
        visited[startY][startX] = true;
        int maxLength = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int length = current[2];

            // 최대 길이 갱신
            maxLength = Math.max(maxLength, length);

            // 4방향 탐색 중 가장 작은 값을 가진 위치 찾기
            int minValue = Integer.MAX_VALUE;
            int[] minPoint = null; // 가장 작은 값을 가지는 포인트 저장
            for (int dir = 0; dir < 4; dir++) {
                int nextY = y + dirY[dir];
                int nextX = x + dirX[dir];

                // 보드 범위 체크 및 방문 여부 체크
                if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < N && !visited[nextY][nextX]) {
                    // 현재 칸의 값보다 작은 값 중 최솟값 확인
                    if (boards[y][x] > boards[nextY][nextX] && boards[nextY][nextX] < minValue) {
                        minValue = boards[nextY][nextX];
                        minPoint = new int[]{nextY, nextX};
                    }
                }
            }

            // 가장 작은 값을 가진 포인트를 큐에 추가
            if (minPoint != null) {
                queue.offer(new int[]{minPoint[0], minPoint[1], length + 1});
                visited[minPoint[0]][minPoint[1]] = true; // 방문 표시
            }
        }
        return maxLength;
    }
}