package swea.d1;

import java.util.Scanner;

public class No2043 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int k = sc.nextInt();

        int n = 0;
        for(int i = k; i <= p; i++){
            n++;
        }

        System.out.println(n);

    }
}
