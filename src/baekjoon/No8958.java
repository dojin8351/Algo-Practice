package baekjoon;

import java.util.Scanner;

public class No8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int totalScore = 0;
            int score = 0;
            String input = sc.next();
            char[] ox = input.toCharArray();

            for (char c : ox) {
                if (c == 'O') {
                    score++;
                } else {
                    score = 0;
                }

                totalScore += score;
            }
            System.out.println(totalScore);
        }
    }
}
