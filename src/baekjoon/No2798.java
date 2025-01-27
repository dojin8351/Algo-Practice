package baekjoon;

import java.util.Scanner;

public class No2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] cards = new int[N];
        for(int i = 0; i < N; i++){
            int card = sc.nextInt();
            cards[i] = card;
        }

        int sum = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                for(int k = j + 1; k < N; k++) {
                    int cardSum = cards[i] + cards[j] + cards[k];
                    if(cardSum <= M) {
                        sum = Math.max(sum, cardSum);
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
