package baekjoon.algostudy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 섬의개수 {
    static int[][] boards;
    static int cnt;
    static boolean[][] visited;
    static int[] dirY = {0,0,1,-1,1,1,-1,-1};
    static int[] dirX = {1,-1,0,0,-1,1,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int[] sizes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = sizes[0];
            int y = sizes[1];
            if(x == 0 && y == 0) {
                return;
            }

            cnt = 0;

            visited = new boolean[y][x];
            boards = new int[y][x];

            for(int i = 0; i < boards.length; i++) {
                boards[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            for(int i = 0; i < boards.length; i++) {
                for(int j = 0; j < boards[i].length; j++) {
                    if(boards[i][j] == 1) {
                        cnt++;
                        bfs(i,j);
                    }

                }
            }
            System.out.println(cnt);
        }
    }

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y,x});
        boards[y][x] = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            for(int i = 0; i < dirY.length; i++) {
                int nextY = curY + dirY[i];
                int nextX = curX + dirX[i];

                if(nextY >= 0 && nextX >= 0 && nextY < boards.length && nextX < boards[0].length && boards[nextY][nextX] == 1) {
                    queue.offer(new int[]{nextY,nextX});
                    boards[nextY][nextX] = 0;
                }
            }
        }
    }
}
