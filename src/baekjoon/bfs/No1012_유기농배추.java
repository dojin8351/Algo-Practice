package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No1012_유기농배추 {
    static int[][] boards;
    static int[] dirY = {0,0,1,-1};
    static int[] dirX = {1,-1,0,0};
    static int M;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int test = 1; test <= testCase; test++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // 배추밭 가로 길이
            M = inputs[0];
            // 배추밭 세로 길이
            N = inputs[1];

            boards = new int[N][M];
            // 배추 심어져있는 위치 개수
            int K = inputs[2];
            for(int i = 0; i < K; i++) {
                int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int x = xy[0];
                int y = xy[1];
                boards[y][x] = 1;
            }
            int bugCnt = 0;
            for(int i = 0; i < boards.length; i++) {
                for(int j = 0; j < boards[i].length; j++) {
                    if(boards[i][j] == 1) {
                        bfs(i,j);
                        bugCnt++;
                    }
                }
            }
            System.out.println(bugCnt);
        }
    }

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        int[] node = {y,x};
        queue.offer(node);

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int curY = current[0];
            int curX = current[1];

            for(int i = 0; i < dirX.length; i++) {
                int nextY = curY + dirY[i];
                int nextX = curX + dirX[i];

                if(nextY >= 0 && nextX >= 0 && nextY < N && nextX < M) {
                    if(boards[nextY][nextX] == 1) {
                        int[] nextNodes = {nextY,nextX};
                        queue.offer(nextNodes);
                        boards[nextY][nextX] = 0;
                    }
                }
            }
        }
    }
}
