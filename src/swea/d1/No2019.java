package swea.d1;

import java.util.Scanner;

public class No2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cumulativeProduct = 1;
        System.out.print(1 + " ");
        for(int i = 0; i < n; i++){
            cumulativeProduct *= 2;
            System.out.print(cumulativeProduct + " ");
        }
    }
}
