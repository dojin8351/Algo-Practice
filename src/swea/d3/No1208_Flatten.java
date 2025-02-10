package swea.d3;

import java.util.Scanner;

public class No1208_Flatten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int testCase = 1; testCase <= 10; testCase++) {
            int dumpCnt = sc.nextInt();
            int[] arr = new int[100];

            for (int i = 0; i < 100; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 0; i < dumpCnt; i++) {
                int max = 0;
                int min = 0;

                for (int j = 0; j < 100; j++) {
                    // 최대값의 index
                    if (arr[j] > arr[max]){
                        max = j;
                    }
                    // 최소값의 index
                    if (arr[j] < arr[min]){
                        min = j;
                    }
                }
                
                // 최대 높이 와 최소 높이의 차가 1,0이면 종료
                if (arr[max] - arr[min] <= 1){
                    break;
                }

                arr[max]--;
                arr[min]++;
            }

            int max = 0;
            int min = 0;
            // dump 수행이 끝났다면 최대 최소을 찾고 출력
            for (int j = 0; j < 100; j++) {
                if (arr[j] > arr[max]){
                    max = j;
                }
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            System.out.println("#" + testCase + " " + (arr[max] - arr[min]));
        }
    }
}