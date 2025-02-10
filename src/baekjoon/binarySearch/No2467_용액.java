package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2467_용액 {
    // 이진탐색 문제
    static int[] liquidArr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        if (N <= 1) {
            return;
        }

        liquidArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        if (st.countTokens() != N) {
            return;
        }

        for (int i = 0; i < N; i++) {
            liquidArr[i] = Integer.parseInt(st.nextToken());
        }
        
        int min = Integer.MAX_VALUE;
        int liquid1 = 0;
        int liquid2 = 0;

        for (int i = 0; i < N - 1; i++) {
            int target = -liquidArr[i];
            int idx = binarySearch(i + 1, N - 1, target);

            if (idx > i && idx < N) {
                int sum = liquidArr[i] + liquidArr[idx];
                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    liquid1 = liquidArr[i];
                    liquid2 = liquidArr[idx];
                }
            }
            if (idx - 1 > i && idx - 1 < N) {
                int sum = liquidArr[i] + liquidArr[idx - 1];
                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    liquid1 = liquidArr[i];
                    liquid2 = liquidArr[idx - 1];
                }
            }
        }
        System.out.println(liquid1 + " " + liquid2);
    }
    
    //이진탐색
    public static int binarySearch(int left, int right, int target) {

        int result = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (liquidArr[mid] >= target) {
                result = mid; // mid를 결과로 기록
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}