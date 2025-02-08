package swea.d3;

import java.util.Scanner;

public class No1289_원재의메모리복구 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int num = 1; num <= testCase; num++) {
            String input = sc.next();

            int cnt = 0;

            if (input.charAt(0) == '1') {
                cnt++;
            }
            for (int i = 1; i < input.length(); i++) {
                if (input.charAt(i - 1) != input.charAt(i)) {
                    cnt++;
                }
            }
            System.out.printf("#%d %d\n", num, cnt);
        }

    }
}
