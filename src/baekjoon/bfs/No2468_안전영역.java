package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No2468_안전영역 {
    static int[][] boards;
    static boolean[][] isUnderwater;

    // 상수 배열로 방향 정의
    static final int[] dirY = {0, 0, -1, 1};
    static final int[] dirX = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        boards = new int[size][size];

        for (int i = 0; i < size; i++) {
            boards[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int maxSafeZone = 0;

        // 아예 안잠길 경우도 생각해야한다.
        for (int water = 0; water <= 100; water++) {
            int underWaterCnt = 0;
            isUnderwater = new boolean[size][size];

            for (int i = 0; i < boards.length; i++) {
                for (int j = 0; j < boards.length; j++) {
                    if (boards[i][j] <= water) {
                        isUnderwater[i][j] = true;
                        underWaterCnt++;
                    }
                }
            }

            // 더 이상 잠길 구역이 없을 경우 멈춤
            if (underWaterCnt == size * size) {
                break;
            }

            int safeZone = 0;
            for (int i = 0; i < isUnderwater.length; i++) {
                for (int j = 0; j < isUnderwater[0].length; j++) {
                    if (!isUnderwater[i][j]) {
                        bfs(isUnderwater, i, j);
                        safeZone++;
                    }
                }
            }

            maxSafeZone = Math.max(maxSafeZone, safeZone);
        }
        System.out.println(maxSafeZone);
    }

    public static void bfs(boolean[][] isUnderwater, int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        isUnderwater[y][x] = true;

        while (!queue.isEmpty()) {
            int[] curNode = queue.poll();
            int curY = curNode[0];
            int curX = curNode[1];

            for (int i = 0; i < dirX.length; i++) {
                int nextY = curY + dirY[i];
                int nextX = curX + dirX[i];

                if (nextY >= 0 && nextX >= 0 && nextY < isUnderwater.length && nextX < isUnderwater[0].length) {
                    if (!isUnderwater[nextY][nextX]) {
                        queue.offer(new int[]{nextY, nextX});
                        isUnderwater[nextY][nextX] = true;
                    }
                }
            }
        }
    }
}