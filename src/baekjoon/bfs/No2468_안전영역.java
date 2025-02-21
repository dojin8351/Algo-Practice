package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2468_안전영역 {
    /*
        - 높이는 1 ~ 100 루프 돌리면서 만약 모든게 다잠기게 되는순간 스톱
     */
    static int[][] boards;
    // 물에 잠김여부확인
    static boolean[][] isUnderwater;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        boards = new int[size][size];
        for(int i = 0; i < size; i++) {
            boards[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
        }
        int maxSafeZone = 0;
        for(int water = 1; water <= 100; water++) {
            int underWaterCnt = 0;
            isUnderwater = new boolean[size][size];
            for(int i = 0; i < boards.length; i++) {
                for(int j = 0; j <boards.length; j++) {
                    if(boards[i][j] <= water) {
                        isUnderwater[i][j] = true;
                        underWaterCnt++;
                    }
                }
            }
            int safeZone = 0;
            for(int i = 0; i < isUnderwater.length; i++) {
                for(int j = 0; j < isUnderwater.length; j++) {
                    if(!isUnderwater[i][j]) {
                        bfs(isUnderwater, i, j);
                        safeZone++;
                    }
                }
            }

            if(safeZone > maxSafeZone) {
                maxSafeZone = safeZone;
            }

            if(underWaterCnt == 0) {
                break;
            }
        }
    }

    public static void bfs(boolean[][] isUnderwater, int y, int x) {

    }
}
