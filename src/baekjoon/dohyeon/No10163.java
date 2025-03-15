package baekjoon.dohyeon;

import java.util.Scanner;

public class No10163 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] map = new int[1001][1001];

        for(int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int width = sc.nextInt();
            int height = sc.nextInt();

            for(int j = x; j < x + width; j++) {
                for(int k = y; k < y + height; k++) {
                    map[j][k] = i;
                }
            }
        }

        int num = 1;
        while(num <= n){
            int cnt = 0;
            for(int i = 0; i < 1001; i++) {
                for(int j = 0; j < 1001; j++) {
                    if(map[i][j] == num) cnt++;
                }
            }
            System.out.println(cnt);
            num++;
        }

    }
}
