package baekjoon.No14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class FirstTryNo14940 {
    /*
        1차시도 메모리 초과 ㅠ
        - 각배열을 순회하면서 최단 거리를 찾는 문제라 생각 그래서 bfs 알고리즘을 사용
        - 탐색 과정을 순차적으로 처리해주기위해 큐를 사용
     */

    // 지점에서 상하좌우를 탐색하기 위해 생성한 도구
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] input = new int[n][m];
        int[][] result = new int[n][m];

        int arrivalRow = 0;
        int arrivalCol = 0;

        //값을 넣어줄때 넣어주는 값이 2이면 그 인덱스를 arrivalRow, arrivalCol에 저장
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                input[i][j] = Integer.parseInt(row[j]);
                if(input[i][j] == 2) {
                    arrivalRow = i;
                    arrivalCol = j;
                }
            }
        }

        //배열 내에서 0, 2가 아니라면 계속 배열을 순회
        // searchArrival에서 반환된 값을 result배열의 같은 곳에 바로 결과를 꽂아준다
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(input[i][j] != 0 && input[i][j] != 2) {
                    result[i][j] = searchArrival(i, j, arrivalRow, arrivalCol, input);
                }
            }
        }

        for(int[] row : result) {
            for(int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }

    }

    private static int searchArrival(int currentRow, int currentCol, int arrivalRow, int arrivalCol, int[][] input) {
        boolean[][] visited = new boolean[input.length][input[0].length];
        Queue<int[]> queue = new LinkedList<>();
        // 초기 세팅 큐에 지금 순회중인 현재 행과 열, 그리고 거리를 0으로 잡아준다
        // {row, col, distance}
        queue.add(new int[]{currentRow, currentCol, 0});

        // 순회하게 된다면 true로 변경
        visited[currentRow][currentCol] = true;

        // 초기 설정으로인해 큐는 비어있지 않게되기때문에 로직시작
        while (!queue.isEmpty()) {
            // current 에 가장 앞의 큐를 꺼내서 반환
            int[] current = queue.poll();

            // row, col, distance 에 위의 큐에서 꺼낸 배열 요소들을 알맞게 매칭
            int row = current[0], col = current[1], distance = current[2];

            // 만약 도착지점의 행과 열이 현재 행과 열과 같다면 그말은 순회를 통해 도착지점에
            // 도착을 했다는 뜻으로 현재 순회를한 지점의 distance를 바로리턴
            if (row == arrivalRow && col == arrivalCol) {
                return distance;
            }

            // directions를 현재 지점의 상하좌우를 서치
            for (int[] direction : DIRECTIONS) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                // 순회도중 배열의 완전 끝을 만나게되거나, visited == false, 0이 아닐때 큐에 다음 넘어갈 지점의
                // 행과 열 이동한 거리를 담은 배열을 새로 추가해준다.
                if (nextRow >= 0 && nextCol >= 0 && nextRow < input.length && nextCol < input[0].length
                        && !visited[nextRow][nextCol] && input[nextRow][nextCol] != 0) {
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol, distance + 1});
                }
            }
        }

        return -1;
    }

}
