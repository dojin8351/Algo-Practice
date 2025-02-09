package baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1926_BFS그림 {
    public static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();

        int[][] map = new int[h][w];

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int count = 0;
        int size = 0;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(map[i][j] == 1) {
                    count++;
                    size = Math.max(size,bfs(map,i,j));
                }
            }
        }
        System.out.println(count);
        System.out.println(size);
    }

    public static int bfs(int[][] map, int h, int w) {
        int size = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{h, w});
        map[h][w] = 0; // 시작점 방문 처리

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            size++;

            for (int[] direction : DIRECTIONS) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && map[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny});
                    map[nx][ny] = 0;
                }
            }
        }
        return size;
    }
}
