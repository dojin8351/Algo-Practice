package baekjoon.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class No1920_수찾기 {
    // 이진탐색을 사용하기전 정렬이 되어야 한다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] board = new int[n];
        for(int i = 0; i < n; i++) {
            board[i] = sc.nextInt();
        }
        Arrays.sort(board);
        int m = sc.nextInt();
        int[] targets = new int[m];
        for(int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        for (int target : targets) {
            if (binarySearch(board, target)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }

    }

    public static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                return true;
            }else if(arr[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }
}
