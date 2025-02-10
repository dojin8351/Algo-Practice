package baekjoon.binarySearch;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class No10816_숫자카드2 {
    static int[] targetCards;
    static int[] checkCards;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] cards = new int[N];
        for(int i = 0; i < N; i++){
            cards[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        targetCards = new int[M];
        checkCards = new int[M];
        for(int i = 0; i < M; i++){
            targetCards[i] = sc.nextInt();
        }
        Arrays.sort(targetCards);

        for(int i = 0; i < cards.length; i++){
            binarySearch(targetCards, cards[i]);
        }
    }

    public static void binarySearch(int[] targetCards, int card) {
        int left = 0;
        int right = targetCards.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(targetCards[mid] == card) {
                return;
            }else if(targetCards[mid] < card) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
    }
}
