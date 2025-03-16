package swea.d3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 규영이와인영이의카드게임 {
    static List<Integer> cards = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18);
    static List<Integer> kyuCards;
    static List<Integer> inCards;
    static boolean[] visited;
    static int loseCnt;
    static int winCnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int test = 1; test <= testCase; test++) {
            winCnt = 0;
            loseCnt = 0;
            kyuCards = new ArrayList<>();
            for(int i = 0; i < 9; i++){
                kyuCards.add(sc.nextInt());
            }
            inCards = new ArrayList<>(cards.stream().filter(card -> !kyuCards.contains(card)).toList());
            visited = new boolean[inCards.size()];

            play(0,0,0);
            System.out.println("#" + test + " " + winCnt + " " + loseCnt);

        }
    }

    public static void play(int cnt, int kScore, int iScore) {
        if(cnt == 9) {
            if(kScore > iScore) {
                winCnt++;
            } else {
                loseCnt++;
            }
            return;
        }

        for(int i = 0; i < 9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                int kCard = kyuCards.get(cnt); // 고정된 kyuCards의 cnt번째 카드를 사용
                int iCard = inCards.get(i); // 순열을 통해 선택된 inCards의 현재 카드 사용

                if(kCard > iCard) {
                    play(cnt+1, kScore + kCard + iCard, iScore);
                } else {
                    play(cnt+1, kScore, iScore + kCard + iCard);
                }

                visited[i] = false;
            }
        }
    }
}
