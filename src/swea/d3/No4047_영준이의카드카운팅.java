package swea.d3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No4047_영준이의카드카운팅 {
    private static final String[] values = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int i = 1; i <= testCase; i++) {
            List<String> sCardList = makeCardList(values, "S");
            List<String> dCardList = makeCardList(values, "D");
            List<String> hCardList = makeCardList(values, "H");
            List<String> cCardList = makeCardList(values, "C");

            String input = sc.next();

            if(input.length() % 3 != 0) {
                System.out.println("#" + i + " ERROR");
                continue;
            }

            boolean error = false;
            for(int j = 0; j < input.length(); j += 3) {
                String card = input.substring(j, j + 3);
                char suit = card.charAt(0);

                switch (suit) {
                    case 'S':
                        if(!sCardList.remove(card)) error = true; break;
                    case 'D':
                        if(!dCardList.remove(card)) error = true; break;
                    case 'H':
                        if(!hCardList.remove(card)) error = true; break;
                    case 'C':
                        if(!cCardList.remove(card)) error = true; break;
                }

                if (error) {
                    System.out.println("#" + i + " ERROR");
                    break;
                }
            }

            if (!error) {
                System.out.printf("#%d %d %d %d %d\n", i, sCardList.size(), dCardList.size(), hCardList.size(), cCardList.size());
            }
        }
        sc.close();
    }

    public static List<String> makeCardList(String[] cards, String suit) {
        List<String> cardList = new ArrayList<>();
        for(String card : cards) {
            cardList.add(suit + card);
        }
        return cardList;
    }
}