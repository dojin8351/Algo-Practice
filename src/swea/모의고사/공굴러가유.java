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

            // 각 위치에서 탐색 시작
            for (int i = 0; i < boards.length; i++) {
                for (int j = 0; j < boards.length; j++) {
                    int y = i;
                    int x = j;
                    int length = 1;

                    while (true) {
                        // 현재 위치에서 최소 값을 찾는다
                        int[] node = searchMin(y, x);

                        if (node == null) {
                            break;
                        }

                        // 다음 위치를 최소값 위치로 갱신
                        y = node[0];
                        x = node[1];

                        length++; // 이동한 경로 길이 증가
                    }

                    // 최대 길이 갱신
                    max = Math.max(max, length);
                }
            }

            // 결과 출력
            System.out.println("#" + test + " " + max);
        }
    }

    // 주어진 위치에서 최소값이 되는 노드 리스트 탐색
    static int[] searchMin(int y, int x) {
        Map<Integer, int[]> nodes = new TreeMap<>();

        for (int dir = 0; dir < dirX.length; dir++) {
            int nextY = y + dirY[dir];
            int nextX = x + dirX[dir];

            // boards범위 내에 존재하면서 더 낮다 라는 조건을 충족한다면 map에 추가해준다.
            if (nextY >= 0 && nextX >= 0 && nextY < boards.length && nextX < boards.length) {
                if (boards[y][x] > boards[nextY][nextX]) {
                    int[] node = {nextY, nextX};
                    nodes.put(boards[nextY][nextX], node);
                }
            }
        }

        if (nodes.isEmpty()) {
            return null;
        }

        // map에 추가된 여러가지의 키값중 가장 작은 값을 가지고 int[] 인 value를 뽑아 반환해준다.
        return nodes.get(nodes.keySet().stream().min(Integer::compareTo).get());
    }
}