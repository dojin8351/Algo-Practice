package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class No11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            int people = sc.nextInt();
            arr[i] = people;
        }

        Arrays.sort(arr);
        int sum = 0;
        int total = 0;
        for (int j : arr) {
            sum += j;
            total += sum;
        }
        System.out.println(total);

    }
}
