package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2630_색종이 {
    // 찢은 종이 사이즈 1이 되거나, 찢은 종이가 하나의 색일때 는 찢는거를 멈춘다
    static int[][] boards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        boards = new int[size][size];
        for(int i = 0; i < size; i++) {
            boards[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

    }

    public int split(int[][] boards) {

        return 0;
    }
}
