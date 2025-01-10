package baekjoon;

import java.util.Scanner;

public class No2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        /*
            구간을 하나씩 확장 n이 어느 구간에 속하는지 알아내는 방식
         */
        int distance = 1;
        int currMax = 1;
        while(n > currMax){
            currMax += 6 * distance;
            distance++;
        }

        System.out.println(distance);
    }
}
