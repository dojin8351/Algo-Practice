package baekjoon.binarySearch;
import java.io.*;
import java.util.*;

public class No10816_숫자카드2 {
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] targets = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        for (int target : targets) {
            int count = upperBound(target) - lowerBound(target);
            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }

    public static int lowerBound(int target) {
        int left = 0, right = cards.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (cards[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static int upperBound(int target) {
        int left = 0, right = cards.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (cards[mid] > target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}

