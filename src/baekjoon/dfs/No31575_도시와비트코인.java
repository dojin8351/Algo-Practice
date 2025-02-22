package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No31575_도시와비트코인 {
    // 오른쪽, 아래로만 이동가능
    static int[] dirY = {0,1};
    static int[] dirX = {1,0};
    static int[] end;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
        int xSize = inputs[0];
        int ySize = inputs[1];
        map = new int[ySize][xSize];

        for(int i = 0; i < ySize; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
        }

        int[] start = {0,0};
        end = new int[]{ySize - 1, xSize - 1};
        visited = new boolean[map.length][map[0].length];
        StringBuilder sb = new StringBuilder();
        if(bfs(0,0)) {
            sb.append("Yes");
        } else {
            sb.append("No");
        }

        System.out.println(sb);
    }

    public static boolean dfs(int y, int x) {
        if (x == end[1] && y == end[0]) {
            return true;
        }

        if (visited[y][x]) {
            return false;
        }

        visited[y][x] = true;

        for (int i = 0; i < 2; i++) {
            int ny = y + dirY[i];
            int nx = x + dirX[i];

            if (ny >= 0 && nx >= 0 && ny < map.length && nx < map[0].length && map[ny][nx] == 1) {
                if (dfs(ny, nx)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y,x});
        visited[y][x] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int curY = current[0];
            int curX = current[1];

            if(curY == end[0] && curX == end[1]){
                return true;
            }

            for(int i = 0; i < 2; i++) {
                int ny = curY + dirY[i];
                int nx = curX + dirX[i];

                if(ny >= 0 && nx >= 0 && ny < map.length && nx < map[0].length && !visited[ny][nx] && map[ny][nx] == 1) {
                    queue.offer(new int[]{ny,nx});
                    visited[ny][nx] = true;
                }
            }
        }

        return false;

    }
}
