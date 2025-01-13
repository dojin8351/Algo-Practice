package swea.d1;

import java.util.Scanner;

public class No2056 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int i = 0; i < testCase; i++) {
            String inputValue = sc.next();

            System.out.printf("#%d %s\n", i+1, format(inputValue));
        }
    }

    public static String format(String date) {
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(4,6));
        int day = Integer.parseInt(date.substring(6,8));

        int[] dayOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month < 1 || month > 12 || day < 1 || day > dayOfMonth[month]) {
            return "-1";
        }

        return String.format("%04d/%02d/%02d", year, month, day);
    }
}
