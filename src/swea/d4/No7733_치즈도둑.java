package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No7733_치즈도둑 {
    /*
        x번째 날에 맛정도X인 칸을 먹는다.
     */
    static int[] dirY = {1,-1,0,0};
    static int[] dirX = {0,0,1,-1};
    static int[][] boards;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int test = 1; test <= testCase; test++) {
            int N = Integer.parseInt(br.readLine());
            boards = new int[N][N];

            for(int i = 0; i < N; i++) {
                boards[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int day = 0;
            int max = 0;
            while(day <= 100) {
                int cnt = 0;
                visited = new boolean[N][N];
                for(int i = 0; i < boards.length; i++) {
                    for(int j = 0; j < boards.length; j++) {
                        if(boards[i][j] <= day) {
                            visited[i][j] = true;
                        }
                    }
                }

                for(int i = 0; i < visited.length; i++) {
                    for(int j = 0; j < visited.length; j++) {
                        if(!visited[i][j]) {
                            bfs(i,j);
                            cnt++;
                        }
                    }
                }
                max = Math.max(cnt,max);

                day++;
            }

            System.out.println("#" + test + " " + max);
        }
    }

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y,x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            for(int i = 0; i < dirY.length; i++) {
                int nextY = curY + dirY[i];
                int nextX = curX + dirX[i];

                if(nextY >= 0 && nextX >= 0 && nextY < boards.length && nextX < boards.length && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    queue.offer(new int[]{nextY, nextX});
                }
            }
        }
     }
}
