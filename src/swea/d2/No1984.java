package swea.d2;

import java.util.*;

public class No1984 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++) {
            int[] arr = new int[10];
            for(int j = 0; j < arr.length; j++){
                arr[j]=sc.nextInt();
            }

            int max = 0;
            int min = 10000 ;
            for (int k : arr) {
                if (k > max) {
                    max = k;
                }
                if (k < min) {
                    min = k;
                }
            }

            int[] result = new int[10];
            for(int j = 0; j < arr.length; j++){
                if(arr[j]==max || arr[j]==min){
                    result[j] = 0;
                }else {
                    result[j]=arr[j];
                }
            }
            int sum = 0;
            for (int j : result) {
                sum += j;
            }
            int cnt = 0;
            for(int j = 0; j < result.length; j++){
                if(result[j]==0){
                    cnt++;
                }
            }
            System.out.printf("#%d %.0f\n", i, (double)sum/(10 - cnt));

        }
    }
}
