package baekjoon;

import java.util.Scanner;

public class No2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int distance = 1;
        int currMax = 1;
        while(n > currMax){
            currMax += 6 * distance;
            distance++;
        }

        System.out.println(distance);
    }
}
