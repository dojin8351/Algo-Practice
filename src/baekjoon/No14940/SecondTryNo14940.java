package baekjoon.No14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SecondTryNo14940 {
    /*
        확인해보니 기존 첫번째 시도때의 코드를 확인해보면 searchArrival 메서드를 호출 할 때마다 visited 배열을 계속 생성
        그로인해 메모리 초기화가 생긴다고 생각 visited없이 수행하도록 수정
     */
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] input = new int[n][m];
        int[][] result = new int[n][m];

        int startRow = 0, startCol = 0;

        // 입력값 초기화 및 도착점(값 2인 지점) 확인
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                input[i][j] = Integer.parseInt(row[j]);
                // 초기 result의 값을 -1로 세팅해 놓음으로서 방문 했는지 안했는지 구분 지을수 있게된다.
                result[i][j] = -1;
                if (input[i][j] == 2) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        // 도착점에서 탐색을 시작하도록 설정
        bfs(startRow, startCol, input, result);

        // 결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int startRow, int startCol, int[][] input, int[][] result) {
        Queue<int[]> queue = new LinkedList<>();

        // 넘겨 받은 도착지점의 행 열을 que에 추가
        queue.add(new int[]{startRow, startCol});

        result[startRow][startCol] = 0; // 도착지점의 거리는 0

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int[] direction : DIRECTIONS) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                // 배열 범위 내에 있어야 하고, 아직 방문하지 않았으며, 값이 1인 지점만 순회
                if (nextRow >= 0 && nextCol >= 0 && nextRow < input.length && nextCol < input[0].length
                        && result[nextRow][nextCol] == -1 && input[nextRow][nextCol] == 1) {
                    // 값을 넣어줌으로써 방문을 했다는게 됨 방문을 안한곳은 여전히 -1
                    result[nextRow][nextCol] = result[row][col] + 1; // 이전 거리 + 1

                    //탐색을 끝마쳤다면 이제 다음 순회할 곳의 행,열의 죄표를 담아 que에 추가
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }

        // 접근하지 못하는 지점은 그대로 -1로 남아있음
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 0) {
                    result[i][j] = 0; // 값이 0인 지점은 0으로 처리
                }
            }
        }
    }
}