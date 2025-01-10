package swea.d1;

import java.util.Arrays;
import java.util.Scanner;

public class No2071 {
    /*
        10개의 수를 입력 받아, 평균값을 출력하는 프로그램을 작성하라.
        (소수점 첫째 자리에서 반올림한 정수를 출력한다.)

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        for(int i = 0; i < testCases; i++) {
            int[] caseValues = new int[10];
            for(int j = 0; j < caseValues.length; j++) {
                int caseValue = sc.nextInt();
                caseValues[j] = caseValue;
            }
            System.out.printf("#%d %.0f\n", i+1, averageValue(caseValues));
        }
    }

    public static double averageValue(int[] arr) {
        int totalValue = 0;
        for(int value : arr) {
            totalValue += value;
        }
        double average = (double) totalValue / arr.length;

        return Math.round(average * 10) / 10.0;
    }
}
