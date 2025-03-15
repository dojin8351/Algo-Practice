package baekjoon.dohyeon;

import java.util.*;

public class No14696 {
    /*
        ★ : 4
        ● : 3
        ■ : 2
        ▲ : 1
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            Map<Integer, Integer> aCards = new HashMap<>();
            Map<Integer, Integer> bCards = new HashMap<>();
            int a = sc.nextInt();
            for (int j = 0; j < a; j++) {
                int card = sc.nextInt();
                aCards.put(card, aCards.getOrDefault(card, 0) + 1);
            }

            int b = sc.nextInt();
            for (int j = 0; j < b; j++) {
                int card = sc.nextInt();
                bCards.put(card, bCards.getOrDefault(card, 0) + 1);
            }

            int[] cardPattern = {4, 3, 2, 1};
            boolean  resultOfGame= false;

            for(int card : cardPattern) {
                int countA = aCards.getOrDefault(card, 0);
                int countB = bCards.getOrDefault(card, 0);

                if(countA > countB) {
                    System.out.println("A");
                    resultOfGame = true;
                    break;
                } else if(countA < countB) {
                    System.out.println("B");
                    resultOfGame = true;
                    break;
                }
            }
            if(!resultOfGame) {
                System.out.println("D");
            }
        }
    }
}
