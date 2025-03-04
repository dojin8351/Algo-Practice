package test.월말대비;

import java.util.*;

public class No1949_등산로조정 {
    /*
        - 등산로의 시작은 가장 높은 봉우리에서 시작(가장 높은 봉우리는 여러개 존재가능)
        - 높은 지형 -> 낮은 지형 (대각선 이동 불가)
        - 긴등산로 제작을 위해 한곳을 정해 최대K만큼 깎는 공사 가능
     */
    static int[][] maps;
    static int[] dirY = {1,-1,0,0};
    static int[] dirX = {0,0,1,-1};
    static Map<Integer, List<int[]>> nodes;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int test = 1; test <= testCase; test++) {
            int N = sc.nextInt(); // map 사이즈
            int K = sc.nextInt(); // 공사 가능 크기
            maps = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    maps[i][j] = sc.nextInt();
                }
            }
            nodes = new HashMap<>();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    nodes.putIfAbsent(maps[i][j], new ArrayList<>());
                    nodes.get(maps[i][j]).add(new int[]{i, j});
                }
            }

            List<Integer> keySet = new ArrayList<>(nodes.keySet());
            keySet.sort(Collections.reverseOrder());
            int maxKey = keySet.get(0);
            // 가장 높은 봉우리의 집합체
            // 가장 높은 봉우리에서 시작
            int result = 0;
            for (int[] node : nodes.get(maxKey)) {
                int y = node[0];
                int x = node[1];
                visited = new boolean[N][N];
                visited[y][x] = true;
                result = Math.max(result, dfs(y, x, maps[y][x], visited, maps, K, 1));
            }

            System.out.println("#" + test + " " + result);
        }
    }

    static int dfs(int y, int x, int height, boolean[][] visited, int[][] maps, int K, int distance) {
        int max = distance; // 현재 상태에서의 최대 거리

        for (int i = 0; i < dirX.length; i++) {
            int nextY = y + dirY[i];
            int nextX = x + dirX[i];

            // 경계 조건 확인 및 방문 여부 체크
            if (nextY < 0 || nextX < 0 || nextY >= maps.length || nextX >= maps[0].length || visited[nextY][nextX]) {
                continue;
            }

            // 다음 위치가 더 낮은 경우
            if (height > maps[nextY][nextX]) {
                visited[nextY][nextX] = true;
                max = Math.max(max, dfs(nextY, nextX, maps[nextY][nextX], visited, maps, K, distance + 1));
                visited[nextY][nextX] = false;

                // 깎아서 이동할 수 있는 경우
            } else if (height > maps[nextY][nextX] - K) {
                int originalHeight = maps[nextY][nextX];
                maps[nextY][nextX] = height - 1; // 최대한 낮게 깎음
                visited[nextY][nextX] = true;
                max = Math.max(max, dfs(nextY, nextX, maps[nextY][nextX], visited, maps, 0, distance + 1));
                visited[nextY][nextX] = false;
                maps[nextY][nextX] = originalHeight; // 원상복구
            }
        }

        return max; // 최댓값 반환
    }

}
