package swea.d3;

import java.util.Scanner;

public class No1940_가랏RC카 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int i = 1; i <= testCase; i++) {
            int N = sc.nextInt();

            int distance = 0;
            int speed = 0;
            for(int j = 1; j <= N; j++) {
                int cases = sc.nextInt();
                if(cases == 1) {
                    int speedChange = sc.nextInt();
                    speed += speedChange;
                } else if(cases == 2) {
                    int speedChange = sc.nextInt();
                    if(speed <= speedChange){
                        speed = 0;
                    }else {
                        speed -= speedChange;
                    }
                }
                distance += speed;
            }
            System.out.printf("#%d %d\n", i, distance);
        }
    }
}
