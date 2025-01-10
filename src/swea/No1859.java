package swea;

import java.util.Scanner;

public class No1859 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int i = 0; i < testCase; i++){
            int caseValueCnt = sc.nextInt();
            int[] values = new int[caseValueCnt];
            for(int j = 0; j < caseValueCnt; j++){
                int value = sc.nextInt();
                values[j] = value;
            }
            System.out.printf( "#%d %d\n",i+1,maxProfit(values));
        }
    }
    public static long maxProfit(int[] prices) {
        long profit = 0;
        int maxPrice = 0;

        // 뒤에서부터 최대 가격 갱신하며 계산
        for (int i = prices.length - 1; i >= 0; i--) {
            // 현재 가격이 최대 가격보다 작다면 이익 계산
            if (prices[i] < maxPrice) {
                profit += maxPrice - prices[i];
            } else {
                // 최대 가격 갱신
                maxPrice = prices[i];
            }
        }
        return profit;
    }
}
