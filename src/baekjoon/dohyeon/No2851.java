package baekjoon.dohyeon;

import java.util.Scanner;

public class No2851 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalScore = 0;
        int preScore = 0;
        int curScore = 0;
        for(int i = 0; i < 10; i++) {
            int mushroom = sc.nextInt();
            totalScore += mushroom;
            if(totalScore >= 100) {
                curScore = totalScore;
                preScore = curScore - mushroom;
                break;
            } else {
                curScore = totalScore;
            }
        }

        if(Math.abs(preScore - 100) == Math.abs(curScore - 100)) {
            System.out.println(curScore);
        } else if(Math.abs(preScore - 100) > (Math.abs(curScore - 100))) {
            System.out.println(curScore);
        } else if(Math.abs(preScore - 100) < (Math.abs(curScore - 100))){
            System.out.println(preScore);
        } else {
            System.out.println(curScore);
        }

    }
}
