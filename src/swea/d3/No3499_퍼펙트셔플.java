package swea.d3;

import java.util.Arrays;
import java.util.Scanner;

public class No3499_퍼펙트셔플 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        for(int i = 1; i <= testCase; i++) {
            int deckSize = sc.nextInt();
            String[] decksArr = new String[deckSize];

            for(int j = 0; j < deckSize; j++) {
                decksArr[j] = sc.next();
            }
            String[] arr1;
            String[] arr2;
            if(decksArr.length % 2 == 0) {
                arr1 = Arrays.copyOfRange(decksArr, 0, decksArr.length / 2);
                arr2 = Arrays.copyOfRange(decksArr, decksArr.length / 2, decksArr.length);
            } else {
                arr1 = Arrays.copyOfRange(decksArr, 0, decksArr.length / 2 + 1);
                arr2 = Arrays.copyOfRange(decksArr, decksArr.length / 2 + 1, decksArr.length);
            }
            String[] result = new String[arr1.length+arr2.length];
            int arr1Index = 0;
            int arr2Index = 0;
            for(int k = 0; k < result.length; k++) {
                if(k % 2 == 0) {
                    result[k] = arr1[arr1Index];
                    arr1Index++;
                } else {
                    result[k] = arr2[arr2Index];
                    arr2Index++;
                }
            }
            System.out.print("#" + i + " ");
            for(String s : result) {
                System.out.print(s + " ");
            }
            System.out.println();

        }
    }
}