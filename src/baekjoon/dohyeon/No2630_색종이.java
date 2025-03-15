package baekjoon.dohyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2630_색종이 {
    // 찢은 종이 사이즈 1이 되거나, 찢은 종이가 하나의 색일때 는 찢는거를 멈춘다
    static int[][] boards;
    static int cnt = 0;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());

        boards = new int[size][size];
        for(int i = 0; i < size; i++) {
            boards[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

    }

    public void split(int[][] boards, int size) {
        int splitSize = size/2;
        int[][] paper1 = new int[splitSize][splitSize];
        int[][] paper2 = new int[splitSize][splitSize];
        int[][] paper3 = new int[splitSize][splitSize];
        int[][] paper4 = new int[splitSize][splitSize];

        for(int i = 0; i < splitSize; i++) {
            for(int j = 0; j < splitSize; j++) {
                paper1[i][j] = boards[i][j];
            }
        }

        for(int i = splitSize; i < size; i++) {
            for(int j = splitSize; j < size; j++) {
                paper2[i][j] = boards[i][j];
            }
        }

        for(int i = 0; i < splitSize; i++) {
            for(int j = splitSize; j < size; j++) {
                paper3[i][j] = boards[i][j];
            }
        }

        for(int i = splitSize; i < size; i++){
            for(int j = 0; j < splitSize; j++) {
                paper4[i][j] = boards[i][j];
            }
        }
    }
}
