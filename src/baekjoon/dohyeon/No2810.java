package baekjoon.dohyeon;

import java.util.Scanner;

public class No2810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int people = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();

        int lCount = 0;
        int sCount = 0;

        int cupHolder = 0;

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == 'L'){
                lCount++;
            }else {
                sCount++;
            }
        }
        cupHolder = lCount/2 + sCount + 1;

        System.out.println(Math.min(cupHolder, people));
    }
}
