package baekjoon.dohyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 색종이 {
    static int maxY = Integer.MIN_VALUE;
    static int minY = Integer.MAX_VALUE;
    static int maxX = Integer.MIN_VALUE;
    static int minX = Integer.MAX_VALUE;
    static List<int[]> points;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        points = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = inputs[0];
            int y = inputs[1];

            points.add(new int[] {x,y});

            maxX = Math.max(maxX,x);
            minX = Math.min(minX,x);
            maxY = Math.max(maxY,y);
            minY = Math.min(minY,y);
        }
        // x는 3을 빼고 y는 2를 빼고 큰 보드를 채워나가보자
        int width = maxX - minX + 10;
        int height = maxY - minY + 10;

        boolean[][] boards = new boolean[height][width];
        for(int[] point : points) {
            int x = point[0] - minX;
            int y = point[1] - minY;

            for(int i = y; i < y+10; i++) {
                for(int j = x; j < x+10; j++) {
                    if(!boards[i][j]) {
                        boards[i][j] = true;
                    }
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {

                if(boards[i][j]) cnt++;
            }
        }
        System.out.println(cnt);

    }
}
