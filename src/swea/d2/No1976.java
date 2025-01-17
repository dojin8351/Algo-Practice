package swea.d2;

import java.util.Scanner;

public class No1976 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            int hour = a + c;
            int min = b + d;

            if(hour > 12 ){
                hour = hour % 12;
                if(min > 60) {
                    hour += min /60;
                    min = min % 60;
                }
            } else {
                if(min > 60) {
                    hour += min /60;
                    min = min % 60;
                }
            }
            System.out.printf("#%d %d %d\n", i+1, hour, min);
        }
    }
}
