package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        String[] scoreInput = br.readLine().split(" ");
        int[] scores = new int[T];

        for (int i = 0; i < T; i++) {
            scores[i] = Integer.parseInt(scoreInput[i]);
        }

        Arrays.sort(scores);
        int M = scores[scores.length - 1];

        float totalScore = 0;
        for (int score : scores) {
            totalScore += (float) score / M * 100;
        }

        float avg = totalScore / T;

        System.out.println(avg);
    }
}
