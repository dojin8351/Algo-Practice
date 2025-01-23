package baekjoon;

import java.util.Scanner;

public class No2527 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 4; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int x3 = sc.nextInt();
            int y3 = sc.nextInt();
            int x4 = sc.nextInt();
            int y4 = sc.nextInt();

            if(x2 < x3 || y2 < y3 || x1 > x4 || y1 > y4) {
                System.out.println("d");
            } else if((x2 == x3 && y2 == y3) || (x1 == x4 && y1 == y4) ||
                 (x2 == x4 && y2 == y4) || (x1 == x3 && y1 == y3)) {
                System.out.println("c");
            } else if(x2 == x3 || x1 == x4 || y2 == y3 || y1 == y4 ) {
                System.out.println("b");
            } else {
                System.out.println("a");
            }
        }
        sc.close();
    }
}
