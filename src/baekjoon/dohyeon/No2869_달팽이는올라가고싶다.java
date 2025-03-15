package baekjoon.dohyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2869_달팽이는올라가고싶다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
        // 낮에 올라갈 수 있는 높이
        int A = inputs[0];
        // 밤에 자는동안 떨어지는 높이
        int B = inputs[1];
        // 나무 막대기의 높이
        int V = inputs[2];

        int result = (V-B) / (A-B);
        if((V-B) % (A-B) != 0) {
            result++;
        }
        System.out.println(result);
    }
}
